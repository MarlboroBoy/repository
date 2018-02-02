package com.sundata.common.base;

import java.util.List;


public abstract class BaseService<T> {

	public abstract BaseMapper<T> getMapper();

	/**
	 * 判断取值于字典YESORNO的字段值是否为真
	 * @param yesOrNo
	 * @return
	 */
	public boolean isTrue(String yesOrNo) {
		if ("1".equals(yesOrNo)) return true;
		return false;
	}

	/**
	 * 根据前台传入的edit属性值判断是否需要进行新增插入处理
	 * @param edit
	 * @return
	 */
	public boolean isInsert(BaseModel data) {
		if ("create".equals(data.fetchSundataEditType())) return true;
		return false;
	}

	/**
	 * 插入一条数据
	 * @param t 待插入数据
	 */
	public void insert(T t) {
    	getMapper().insert(t);
    }

	/**
	 * 按条件删除
	 * @param ids 删除条件数组
	 * @return 删除记录数
	 */
	public void delete(Object... ids) {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			getMapper().delete(id);
		}
	}
	
	/**
	 * 按条件更新
	 * @param t 更新条件及数据
	 * @return 修改记录数
	 */
	public int update(T t) {
    	return getMapper().update(t);
    }

	/**
	 * 按条件更新非空字段
	 * @param t 更新条件及数据
	 * @return 修改记录数
	 */
	public int updateNotEmpty(T t) {
    	return getMapper().updateNotEmpty(t);
    }	

	/**
	 * 查询单条详细信息，应在确定参数非空时使用，否则会返回null
	 * @param cond 查询条件
	 * @return 查询结果
	 */
	public T queryOne(String cond){
		return getMapper().queryOne(cond);
	}
	/**
	 * 查询单条详细信息，如果查询结果为空则返回查询条件，主要用于详细信息页面查询，在新增时自动初始化所有属性为默认值
	 * 如果需要新增时设置特定的默认值，请重写此方法
	 * @param cond
	 * @return
	 */
	public T queryOne(T cond){
		T rst = getMapper().queryOne(cond);
		if (rst == null)
			return cond;
		return rst;
	}

	/**
	 * 判断是否不存在满足条件的记录
	 * @param cond 查询条件对象
	 * @return 是否
	 */
	public String isNotExist(Object cond) {
		T rst = getMapper().queryOne(cond);
		if (rst == null)
			return "true";
		return "代码已存在";
	}
	/**
	 * 查询数据列表
	 * @param cond 查询条件
	 * @return 查询结果列表
	 */
	public List<T> queryList(Object cond){
		return getMapper().queryList(cond);
	}

	/**
	 * 分页查询
	 * @param model 带分页信息的查询条件
	 * @return 查询结果Map
	 */
	/**	public Map<String,Object> queryPage(BasePageModel model) {
		return queryPage(false, model);
	}
	
	 * 分页查询，固定调用id为queryPage的sql，如果查询语句非常复杂，自动生成的查询记录数SQL执行缓慢，
	 *   可以将第一个参数设为true并编写id为queryPageCount的sql作为查询记录数逻辑
	 * @param hasSeperateCountSql 是否有单独的查询记录数的SQL
	 * @param model 带分页信息的查询条件对象
	 * @return 查询结果Map
	
	public Map<String,Object> queryPage(Boolean hasSeperateCountSql, BasePageModel model) {
		if (hasSeperateCountSql) {
			Integer rowCount = getMapper().queryPageCount(model);
			model.getPager().setRowCount(rowCount);
		}
		List<T> dataList = getMapper().queryPage(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		return jsonMap;
	} */
	
}
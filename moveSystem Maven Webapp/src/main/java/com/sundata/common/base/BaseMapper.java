package com.sundata.common.base;

import java.util.List;


public interface BaseMapper<T> {

	/**
	 * 插入一条数据
	 * @param t 待插入数据
	 */
	public void insert(T t);
	/**
	 * 按条件删除
	 * @param cond 删除条件
	 * @return 删除记录数
	 */
	public int delete(Object cond);
	/**
	 * 按条件更新
	 * @param t 更新条件及数据
	 * @return 修改记录数
	 */
	public int update(T t);

	/**
	 * 按条件更新非空字段，需要指定更新某些字段时，可使用此方法
	 * @param t 更新条件及数据
	 * @return 修改记录数
	 */
	public int updateNotEmpty(T t); 	
	/**
	 * 查询一条数据
	 * @param cond 查询条件
	 * @return 查询结果
	 */
	public T queryOne(Object cond);
	/**
	 * 查询数据列表
	 * @param cond 查询条件
	 * @return 查询结果列表
	 */
	public List<T> queryList(Object cond);
	/**
	 * 查询记录数
	 * @param model 带分页信息的查询条件
	 * @return 记录数
	 */
	//public int queryPageCount(BasePageModel model);
	/**
	 * 分页查询
	 * @param model 带分页信息的查询条件
	 * @return 查询结果列表
	 */
//	public List<T> queryPage(BasePageModel model);

	
}

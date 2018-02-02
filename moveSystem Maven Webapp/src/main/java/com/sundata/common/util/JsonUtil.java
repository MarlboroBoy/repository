package com.sundata.common.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sundata.common.exception.ServiceException;

public class JsonUtil {

	
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 对象转json格式字符串
	 * @param obj 待转换对象
	 * @return json格式字符串
	 */
	static public String toJSONString(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new ServiceException("对象转json格式失败", e);
		}
	}

	/**
	 * json格式字符串转指定类型对象
	 * @param str json格式字符串
	 * @param valueType 对象类型
	 * @return 指定类型的对象
	 */
	static public <T> T analJSONString(String str, Class<T> valueType) {
		try {
			return objectMapper.readValue(str, valueType);
		} catch (Exception e) {
			throw new ServiceException("json字符串["+str+"]转对象失败", e);
		}
	}

	/**
	 * json格式字符串转指定类型的map
	 * @param str		json格式字符串
	 * @param keyType	map中key的类型
	 * @param valueType	map中value的类型
	 * @return	Map对象
	 */
	public static <K, V> Map<K, V> jsonToMap(String str) {
		try {
			return objectMapper.readValue(str, new TypeReference<Map<K, V>>() {});
		} catch (Exception e) {
			throw new ServiceException("json字符串转map失败", e);
		}
	}

	/**
	 * json格式字符串转指定类型的list
	 * @param str		json格式字符串
	 * @param valueType	list中value的类型
	 * @return	List对象
	 */
	public static <T> List<T> jsonToList(String str) {
		try {
			return objectMapper.readValue(str, new TypeReference<List<T>>() {});
		} catch (Exception e) {
			throw new ServiceException("json字符串转list失败", e);
		}
	}

	/**
	 * json格式字符串转存储指定泛型的map的list
	 * @param str	json格式字符串
	 * @return list对象
	 */
	public static <K, V> List<Map<K, V>> jsonToMapList(String str) {
		try {
			return objectMapper.readValue(str, new TypeReference<List<Map<K, V>>>() {});
		} catch (Exception e) {
			throw new ServiceException("json字符串转map失败", e);
		}
	}
}

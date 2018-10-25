package com.application.boot.redis.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @desc JsonUtils 工具
 *
 */
public class JsonUtils {

	/**
	 * key 分隔符
	 */
	private static String KEY_SPLIT_FLAG = ".";

	/**
	 * Gson实例
	 */
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();  

	private static Gson format = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create();
	
	private static Gson hasNull = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	
	public final static Gson birthday = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();
	
	/**
	 * 
	   @Desecration  
	 */
	public static String  parseBeanToJson(Object object) {
		return gson.toJson(object);
	}
	/**
	 * TODO 将为null值的字段也返回
	 * @author zhanghan
	 * @date	2017年3月22日
	 * @return
	 */
	public static String parseBeanToJsonHasNull(Object object) {
		return hasNull.toJson(object);
	}
	
	
	/**
	 * TODO 格式化json
	 */
	public static String parseBeanToFormatJson(Object object) {
		return format.toJson(object);
	}

	/**
	 * 将json串转换成java对象
	 * 
	 * @param <T>
	 * @param classes
	 * @param json
	 * @return
	 */
	public static <T> T parseJsonToBean(Class<T> classes, String json) {
		T t= gson.fromJson(json, classes);
		return t;
	}
	
	/**
	 * 将json串转换成java对象
	 * 
	 * @param json
	 * @return
	 */
	 public static <T> T fromJson(String json, Type type) {
	     T t= gson.fromJson(json, type);
	     return  t; 
	 }
	 
	 
	 /**
	  * 将json串转换成java对象
	  * @param json
	  * @return
	  */
    public static <T> T fromJsonDes(String json, Type type) {
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new GsonMapTypeAdapter()).create();
        return gson.fromJson(json, type);
    }
	 
	/**
	 * 判断String是否是空 为空的情况包含：对象为空,为空字符串（""）,为字符串"null"
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String value) {
		if (value == null || "".equals(value.trim())
				|| "null".equals(value.trim())) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("String", "string");
		map.put("Integer", 1);
		map.put("Date", new Date());
		list.add(map);
		JsonUtils.parseBeanToJson(list);
	}
}

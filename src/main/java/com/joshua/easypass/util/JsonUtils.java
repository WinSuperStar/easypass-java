package com.joshua.easypass.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonUtils {
	public static ObjectMapper getMapper(boolean ignoreUnknownProperties){
		ObjectMapper mapper = new ObjectMapper();
		if(ignoreUnknownProperties){
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
        SimpleModule module = new SimpleModule();
        mapper.registerModule(module);
		return mapper;
	}
	
	public static ObjectMapper getMapper(){
		return getMapper(true);
	}
	
	public static <T> T  jsonToBean(String jsonString, Class<T> resultClass,boolean ignoreUnknownProperties){ 
		ObjectMapper mapper = getMapper(ignoreUnknownProperties);
		T t = null;
        try {
            t = mapper.readValue(jsonString, resultClass);
        } catch(Exception e ){
        	e.printStackTrace();
        }
        return t;
	}
	
	public static <T> T  jsonToBean(String jsonString, Class<T> resultClass){ 
        return jsonToBean(jsonString,resultClass,true);
	}
	
	public static <T> T  jsonToBean(String jsonString, TypeReference<T> valueTypeRef,boolean ignoreUnknownProperties){ 
		ObjectMapper mapper = getMapper(ignoreUnknownProperties);
		T t = null;
        try {
            t = mapper.readValue(jsonString, valueTypeRef);
        } catch(Exception e ){
        	e.printStackTrace();
        }
        return t;
	}
	
	public static <T> List<T> jsonToList(String jsonString, Class<T> elementClasses){ 
		ObjectMapper mapper = getMapper(); 
		List<T> t = null;
        try {
            t = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClasses));
        } catch(Exception e ){
        	e.printStackTrace();
        }
        return t;
	}
	
	
	public static String  beanToJson(Object object){ 
		ObjectMapper mapper = getMapper();
		String  jsonString = null;
        try {
        	jsonString = mapper.writeValueAsString(object);
        } catch(Exception e ){
        	e.printStackTrace();
        }
        return jsonString;
	}
}

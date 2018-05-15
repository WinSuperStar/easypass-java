package com.joshua.easypass.util;

public class ObjectHelper {

    public static String join(Object[] array) {
    	StringBuffer s  = new StringBuffer();
        if (array == null) {
            return null;
        }
        for(Object o : array) {
        	if(o instanceof String) {
        		s.append(","+o.toString());
        	}
        }
        
        return  s.toString().substring(1);
    }
}

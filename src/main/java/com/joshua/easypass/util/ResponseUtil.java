package com.joshua.easypass.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.joshua.easypass.encap.Result;

public class ResponseUtil {

    public static void write(HttpServletResponse response,Result o) {  
        response.setContentType("application/json; charset=utf-8");  
        PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(JsonUtils.beanToJson(o)); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        out.flush();  
	        out.close();  
		}

    }  
}

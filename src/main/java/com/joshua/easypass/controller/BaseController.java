package com.joshua.easypass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.joshua.easypass.config.properties.FileUploadProperties;

@Controller
public class BaseController {

	@Autowired
	protected HttpServletRequest request;
	
	
	@Autowired
	protected HttpServletResponse response;
	
	@Autowired
	protected FileUploadProperties fileUploadProperties;
		
}

package com.joshua.easypass.config.properties;

import java.util.List;

public class ModuleType {

	private String name;
	
	private String filePath;
	
	private List<UploadType> uploadTypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<UploadType> getUploadTypes() {
		return uploadTypes;
	}

	public void setUploadTypes(List<UploadType> uploadTypes) {
		this.uploadTypes = uploadTypes;
	}
	
	
}

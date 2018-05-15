package com.joshua.easypass.config.properties;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.joshua.easypass.util.FileUtils;

@Configuration
@ConfigurationProperties(prefix = FileUploadProperties.FILE_UPLOAD_PREFIX)
public class FileUploadProperties {
	
	public static final String FILE_UPLOAD_PREFIX = "upload";
	
	private String defaultDomain;
		
	private String baseDir = "/data/files";
	
	private String maxFileSize = "2M";
	
	private String maxRequestSize = "10M";
	
	private List<ModuleType> moduleTypes;
	
	private boolean open = false;
	
	public String getDefaultDomain() {
		return defaultDomain;
	}

	public void setDefaultDomain(String defaultDomain) {
		this.defaultDomain = defaultDomain;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public List<ModuleType> getModuleTypes() {
		return moduleTypes;
	}

	public void setModuleTypes(List<ModuleType> moduleTypes) {
		this.moduleTypes = moduleTypes;
	}

	public String getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(String maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public String getMaxRequestSize() {
		return maxRequestSize;
	}

	public void setMaxRequestSize(String maxRequestSize) {
		this.maxRequestSize = maxRequestSize;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean validateAalidityFile(String moduleName , MultipartFile file) {
		
		String originalFilename = file.getOriginalFilename();
		boolean isSupportUploadType = FileUtils.validateUploadType(originalFilename);
		if(!validateAalidityModule(moduleName) || file == null || !isSupportUploadType) {
			return false;
		}
		String uploadTypeName = FileUtils.getUploadType(originalFilename);
		return (isSupportUploadType && validateSettingByUploadTypeAndModuleName(moduleName,uploadTypeName));
	}
	
	public boolean validateAalidityModule(String moduleName) {
		if(moduleTypes == null) {
			return false;
		}
		if(StringUtils.isBlank(moduleName)) {
			return false;
		}
		
	    for(ModuleType moduleType : moduleTypes) {
			if(moduleType.getName().equals(moduleName)) {
				return true;
			}else {
				continue;
			}
		}
		return false;
	}	
	
	public boolean validateSettingByUploadTypeAndModuleName(String moduleName,String uploadTypeName){
		for(UploadType uploadType : getSettingUploadTypeByModuleName(moduleName)) {
			if(uploadType.getName().equals(uploadTypeName)) {
				return true;
			}else {
				continue;
			}
		}
		
		return false;
	}
	
	public List<UploadType> getSettingUploadTypeByModuleName(String moduleName){
		List<UploadType> uploadTypes = new ArrayList<UploadType>();
	    for(ModuleType moduleType : moduleTypes) {
			if(moduleType.getName().equals(moduleName)) {
				uploadTypes.addAll(moduleType.getUploadTypes());
				break;
			}
		}
	    return uploadTypes;
	}
	
	
	
	public String getDomain(String moduleName,String uploadTypeName){
		if(StringUtils.isNotBlank(defaultDomain)) {
			return defaultDomain;
		}
		
	    for(ModuleType moduleType : moduleTypes) {
			if(moduleType.getName().equals(moduleName)) {
				for(UploadType uploadType : moduleType.getUploadTypes()) {
					if(uploadType.getName().equals(uploadTypeName)) {
						return uploadType.getDomain();
					}
				}
			}
		}
	    return null;
	}
}

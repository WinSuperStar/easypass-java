package com.joshua.easypass.controller.business;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.joshua.easypass.config.properties.FileUploadProperties;
import com.joshua.easypass.encap.Result;
import com.joshua.easypass.encap.UploadResult;
import com.joshua.easypass.util.FileUtils;

@RestController("/upload")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FileUploadController {
	
	@Autowired 
	private FileUploadProperties fileUploadProperties;

	@PostMapping(value = "")
	public Result<UploadResult> fileUpload(MultipartHttpServletRequest request){
		Result<UploadResult> result  = new Result<UploadResult>();
		UploadResult uploadResult = new UploadResult();
		uploadResult.setRelativeStorePath("");
		List<MultipartFile> files = request.getFiles("fileName");
        if(files==null || files.isEmpty() ) {
        	result.setCode(1);
        	result.setMsg("上传文件不能够为空");
        	return result;
        }
		String moduleName = request.getParameter("moduleName");
		for(MultipartFile file : files) {
			if(fileUploadProperties.validateAalidityFile(moduleName, file)) {
	        	result.setCode(1);
	        	result.setMsg("上传文件业务模块的名称必须配置或者上传文件类型未配置");
	        	return result;
			}
		}
		
		try {
			for(MultipartFile file : files) {
				Result<UploadResult> r = FileUtils.saveFile(file.getInputStream(),fileUploadProperties.getBaseDir(),moduleName,file.getOriginalFilename(), false);
				if(r!=null&&r.getCode()==0) {
					uploadResult.setRelativeStorePath(uploadResult.getRelativeStorePath()+","+r.getData().getRelativeStorePath());
					uploadResult.setDomain(fileUploadProperties.getDomain(moduleName, FileUtils.getUploadType(file.getOriginalFilename())));
				}else {
					return r;
				}
			}
			String relativeStorePath = uploadResult.getRelativeStorePath();
			uploadResult.setRelativeStorePath(relativeStorePath.substring(1));
		} catch(IOException e){
        	result.setCode(1);
        	result.setMsg("上传文件失败，请联系系统管理员：" + e.getMessage());
		}
		result.setData(uploadResult);
		return result;
	}	
	
}

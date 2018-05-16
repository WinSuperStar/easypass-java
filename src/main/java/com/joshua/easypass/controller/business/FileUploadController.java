package com.joshua.easypass.controller.business;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joshua.easypass.config.properties.FileUploadProperties;
import com.joshua.easypass.controller.BaseController;
import com.joshua.easypass.encap.Result;
import com.joshua.easypass.encap.UploadResult;
import com.joshua.easypass.util.FileUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FileUploadController extends BaseController {
	
	@Autowired 
	private FileUploadProperties fileUploadProperties;

	@PostMapping(value = "/upload")
	public Result<UploadResult> fileUpload(@RequestParam MultipartFile[] files){
		Result<UploadResult> result  = new Result<UploadResult>();
		UploadResult uploadResult = new UploadResult();
		uploadResult.setRelativeStorePath("");
        if(files==null || files.length == 0 ) {
        	result.setCode(1);
        	result.setMsg("上传文件不能够为空");
        	return result;
        }
		String moduleName = getRequest().getParameter("moduleName");
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

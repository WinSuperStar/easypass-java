package com.joshua.easypass.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.joshua.easypass.encap.Result;
import com.joshua.easypass.encap.UploadResult;

public class FileUtils {
	
	public static final Integer RESULT_ERROR = 1;
	public static final Integer RESULT_SUCESS = 0;
	
	public static Result<UploadResult> saveFile(InputStream stream,String realPath,String filePath, String originalName) {
		return saveFile(stream,realPath,filePath,originalName,false);
	}

	public static Result<UploadResult> saveFile(InputStream stream,String realPath,String moduleName, String originalName,boolean isUsedOriginalName) {
		Result<UploadResult> result = new Result<UploadResult>();
		UploadResult uploadResult = new UploadResult();
		OutputStream bos = null;
		String suffix = originalName.substring(originalName.lastIndexOf(".")),fileName=null;
		if(isUsedOriginalName) {
			fileName = originalName.substring(originalName.lastIndexOf("/")+1);
		} else {
			fileName = UUID.randomUUID().toString().replaceAll("-", "")+RandomStringUtils.randomNumeric(5)+suffix;
		}
		String toFilePath = mergeFilePath(realPath,FileUtils.getUploadType(fileName),moduleName);
		String toFile = toFilePath+"/"+fileName;
		try {
			makeFolder(toFilePath);
            bos = new FileOutputStream(toFile);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            stream.close();
            
            uploadResult.setRelativeStorePath(mergeFilePath(FileUtils.getUploadType(fileName),moduleName,fileName));
            result.setCode(RESULT_SUCESS);
            result.setData(uploadResult);
		} catch(IOException e) {
			result.setCode(RESULT_ERROR);
			result.setMsg(e.getMessage());
		} finally {
            try{
                bos.close();
                stream.close();
            } catch (Exception e) {}
        }
		return result;
	}
	
	public static String getUploadType(String fileName) {
		if (fileName == null) {
			fileName = "文件名为空！";
			return null;

		} else {
			// 获取文件后缀名并转化为写，用于后续比较
			String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
			// 创建图片类型数组
			String img[] = { "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd", "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf" };
			for (int i = 0; i < img.length; i++) {
				if (img[i].equals(fileType)) {
					return "images";
				}
			}

			// 创建文档类型数组
			String document[] = { "txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt" };
			for (int i = 0; i < document.length; i++) {
				if (document[i].equals(fileType)) {
					return "docs";
				}
			}
			// 创建视频类型数组
			String video[] = { "mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm" };
			for (int i = 0; i < video.length; i++) {
				if (video[i].equals(fileType)) {
					return "videos";
				}
			}
			// 创建音乐类型数组
			String music[] = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg", "m4a", "vqf" };
			for (int i = 0; i < music.length; i++) {
				if (music[i].equals(fileType)) {
					return "musics";
				}
			}
		}
		return null;
	}
	
	public static boolean validateUploadType(String fileName) {
		String uploadType = getUploadType(fileName);
		if(StringUtils.isBlank(uploadType)) {
			return false;
		}
		return true;
	}
	
	public static boolean makeFolder(String strDir) {
		File fileNew = new File(strDir);
		if (!fileNew.exists()) {
			return fileNew.mkdirs();
		} else {
			return true;
		}
	}
	
    public static String  mergeFilePath(String ...filePath) {
    	StringBuffer path = new StringBuffer();
    	for(String f :  filePath) {
    		if(!f.startsWith("/")) {
    			path.append("/").append(f);
    		}else {
    			path.append(f);
    		}
    	}
    	return path.toString();
    }
	
}

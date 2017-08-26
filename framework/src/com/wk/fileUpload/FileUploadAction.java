package com.wk.fileUpload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private File file1;
	
	private String file1ContentType;
	
	private String file1FileName;

	

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}


	@Override
	public String execute() throws Exception {
		
		//获取上传的目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//创建文件
		File destFile = new File(path,file1FileName);
		
		//把上传的文件拷贝到创建的目标文件中
		FileUtils.copyFile(file1, destFile);
		return "success";
	}
	
	
}

package com.wk.file_upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class FileServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		System.out.println(request.getParameter("method"));
		try {
			//一、创建文件上传工厂类
			FileItemFactory fif = new DiskFileItemFactory();
			
			//二、创建文件上传核心工具类
			
			ServletFileUpload sfu = new ServletFileUpload(fif);
			
			//设置文件最大字节 30M
			sfu.setFileSizeMax(30*1024*1024);
			
			//设置文件上传表单允许总大小 80M
			sfu.setSizeMax(80*1024*1024);
			
			//设置上传表单文件名的编码格式
			sfu.setHeaderEncoding("utf-8");
			
			//三、判断是否为文件上传表单
			if(sfu.isMultipartContent(request)){
				
				//把请求数据解析为为多个FileItem对象，返回一个集合
				List<FileItem> fileItems = sfu.parseRequest(request);
				
				for (FileItem item : fileItems) {
					
					//如果是普通文本数据
					
					if(item.isFormField()){
						
						String elemName = item.getFieldName();//表单元素名称
						String value = item.getString();  //获取元素值
//						System.out.println(elemName+"--"+value);
					}
					
					//文件数据
					else{
						
						String fieldName = item.getFieldName();  //表单元素
						String fileName = item.getName();		//文件名
						
						String content = item.getString();   //表单元素对应的值，这里是文件内容
						String type = item.getContentType();
						InputStream is = item.getInputStream();  //文件输入流
					}
				
				
				}
			}else {
				System.out.println("不是文件上传表单");
			}
			
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		}
		
	}

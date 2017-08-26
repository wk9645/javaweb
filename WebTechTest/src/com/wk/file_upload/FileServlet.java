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
			//һ�������ļ��ϴ�������
			FileItemFactory fif = new DiskFileItemFactory();
			
			//���������ļ��ϴ����Ĺ�����
			
			ServletFileUpload sfu = new ServletFileUpload(fif);
			
			//�����ļ�����ֽ� 30M
			sfu.setFileSizeMax(30*1024*1024);
			
			//�����ļ��ϴ��������ܴ�С 80M
			sfu.setSizeMax(80*1024*1024);
			
			//�����ϴ����ļ����ı����ʽ
			sfu.setHeaderEncoding("utf-8");
			
			//�����ж��Ƿ�Ϊ�ļ��ϴ���
			if(sfu.isMultipartContent(request)){
				
				//���������ݽ���ΪΪ���FileItem���󣬷���һ������
				List<FileItem> fileItems = sfu.parseRequest(request);
				
				for (FileItem item : fileItems) {
					
					//�������ͨ�ı�����
					
					if(item.isFormField()){
						
						String elemName = item.getFieldName();//��Ԫ������
						String value = item.getString();  //��ȡԪ��ֵ
//						System.out.println(elemName+"--"+value);
					}
					
					//�ļ�����
					else{
						
						String fieldName = item.getFieldName();  //��Ԫ��
						String fileName = item.getName();		//�ļ���
						
						String content = item.getString();   //��Ԫ�ض�Ӧ��ֵ���������ļ�����
						String type = item.getContentType();
						InputStream is = item.getInputStream();  //�ļ�������
					}
				
				
				}
			}else {
				System.out.println("�����ļ��ϴ���");
			}
			
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		}
		
	}

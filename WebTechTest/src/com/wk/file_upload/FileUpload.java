package com.wk.file_upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUpload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("upload".equals(method))
			upload(request, response);
		if("downList".equals(method))
			download(request, response);
		if("down".equals(method))
			down(request, response);
	}
	
	
	/*
	 * �ϴ�
	 */

	public void upload(HttpServletRequest request,HttpServletResponse response){
		
		
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
					 
				
					// �ļ�����
					else {
						//******** �ļ��ϴ� ***********//*
						// a. ��ȡ�ļ�����
						String name = item.getName();
						System.out.println(name);
						//�����ϴ��ļ�����������
						//�ȵõ�Ψһid
						String id = UUID.randomUUID().toString();
						//ƴ���ļ���
						name = id + "#" + name;
						
						//b. ��ȡ�ϴ�Ŀ¼
						
						String basePath = getServletContext().getRealPath("/upload");  //��ȡ����·��
						
						//c. ����Ҫ�ϴ����ļ�
						File file = new File(basePath,name);
						
						//d. �ϴ�
						item.write(file);
						
						System.out.println("���ϴ�");
						item.delete();  //ɾ���������ʱ��������ʱ�ļ�
					}
				}
			}else {
				System.out.println("�����ļ��ϴ���");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 *  ������������
	 */
	
	
	public void download(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		//ʹ��map�洢���Ѵ���id���ļ����ͼ��ļ�����Ϊһ�Լ�ֵ
		
		Map<String, String> fileNames = new HashMap<String, String>();
		
		
		//��ȡ�ϴ�Ŀ¼���ڻ�ȡĿ¼�µ������ļ�
		
		String basePath = getServletContext().getRealPath("/upload");
		
		File file = new File(basePath);  //��װΪFile����
		
		String[] files = file.list();  //�����ļ�
		if(files != null && files.length>0){
			for (int i=0;i<files.length;i++) {
				
				String aName = files[i];  //��ȡ�ļ�ȫ��
				String sName = aName.substring(aName.lastIndexOf("#") + 1);  //�ļ���
				
				fileNames.put(aName, sName);
			}
		}
		
		System.out.println(fileNames);
		//������request����
		request.setAttribute("fileNames", fileNames);
		
		//ת��
		
		request.getRequestDispatcher("/fileDownload.jsp").forward(request, response);
	
	}
	
	/*
	 * �������ع���
	 */
	
	public void down(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		
			System.out.println("���뵽down������");
		
			// ��ȡ�û����ص��ļ�����(url��ַ��׷������,get)
			String fileName = request.getParameter("fileName");
			fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
			

			String basePath = getServletContext().getRealPath("/upload");
			// ��ȡһ���ļ���
			InputStream in = new FileInputStream(new File(basePath,fileName));
			
			// ����ļ��������ģ���Ҫ����url����
			fileName = URLEncoder.encode(fileName, "UTF-8");
			// �������ص���Ӧͷ
			response.setHeader("content-disposition", "attachment;fileName=" + fileName);
			
			// ��ȡresponse�ֽ���
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = in.read(b)) != -1){
				out.write(b, 0, len);
			}
			// �ر�
			out.close();
			in.close();
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
	
		try {
			this.doGet(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}













/*

 * ʹ�����ʵ���ļ��ϴ�
 



*/
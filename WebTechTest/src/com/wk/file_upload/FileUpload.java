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
	 * 上传
	 */

	public void upload(HttpServletRequest request,HttpServletResponse response){
		
		
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
					 
				
					// 文件表单项
					else {
						//******** 文件上传 ***********//*
						// a. 获取文件名称
						String name = item.getName();
						System.out.println(name);
						//处理上传文件名重名问题
						//先得到唯一id
						String id = UUID.randomUUID().toString();
						//拼接文件名
						name = id + "#" + name;
						
						//b. 获取上传目录
						
						String basePath = getServletContext().getRealPath("/upload");  //获取绝对路径
						
						//c. 创建要上传的文件
						File file = new File(basePath,name);
						
						//d. 上传
						item.write(file);
						
						System.out.println("已上传");
						item.delete();  //删除组件运行时产生的临时文件
					}
				}
			}else {
				System.out.println("不是文件上传表单");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 *  设置下载内容
	 */
	
	
	public void download(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		//使用map存储，把带有id的文件名和简单文件名作为一对键值
		
		Map<String, String> fileNames = new HashMap<String, String>();
		
		
		//获取上传目录，在获取目录下的所有文件
		
		String basePath = getServletContext().getRealPath("/upload");
		
		File file = new File(basePath);  //封装为File对象
		
		String[] files = file.list();  //所有文件
		if(files != null && files.length>0){
			for (int i=0;i<files.length;i++) {
				
				String aName = files[i];  //获取文件全名
				String sName = aName.substring(aName.lastIndexOf("#") + 1);  //文件名
				
				fileNames.put(aName, sName);
			}
		}
		
		System.out.println(fileNames);
		//保存在request域中
		request.setAttribute("fileNames", fileNames);
		
		//转发
		
		request.getRequestDispatcher("/fileDownload.jsp").forward(request, response);
	
	}
	
	/*
	 * 处理下载过程
	 */
	
	public void down(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		
			System.out.println("进入到down方法中");
		
			// 获取用户下载的文件名称(url地址后追加数据,get)
			String fileName = request.getParameter("fileName");
			fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
			

			String basePath = getServletContext().getRealPath("/upload");
			// 获取一个文件流
			InputStream in = new FileInputStream(new File(basePath,fileName));
			
			// 如果文件名是中文，需要进行url编码
			fileName = URLEncoder.encode(fileName, "UTF-8");
			// 设置下载的响应头
			response.setHeader("content-disposition", "attachment;fileName=" + fileName);
			
			// 获取response字节流
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = in.read(b)) != -1){
				out.write(b, 0, len);
			}
			// 关闭
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

 * 使用组件实现文件上传
 



*/
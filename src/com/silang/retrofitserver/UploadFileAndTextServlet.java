package com.silang.retrofitserver;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


@WebServlet("/UploadFileAndTextServlet")
public class UploadFileAndTextServlet  extends HttpServlet {
	    protected void doPost(HttpServletRequest request,
	                          HttpServletResponse response) throws ServletException, IOException {
	        //设置utf8编码
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        response.setHeader("content-type","text/html;charset=UTF-8");

	        try {
	            //初始化
	            SmartUpload smartUpload = new SmartUpload();
	            smartUpload.initialize(this.getServletConfig(), request, response);
	            smartUpload.uploadInFile("utf-8");
	            //获取writeOff数据的json字符串
	            String json = smartUpload.getRequest().getParameter("content");
	            System.out.println("content:" + json);
	           
	            //获取文件信息并保存
	            Files files = smartUpload.getFiles();
	            for (int i = 0; i < files.getCount(); i++) {
	                com.jspsmart.upload.File file = files.getFile(i);
	                System.out.println("fileName:" + file.getFileName());
	                System.out.println("fieldName:" + file.getFieldName());
	           
	                //获取随机字符串
	                String name = UUID.randomUUID().toString();
	                //保存路径
	                String savePath = this.getServletContext().getRealPath("WEB-INF") + "/" + name + ".jpg";
	                //保存
	                file.saveAs(savePath);
	                System.out.println("保存成功：" + savePath);
	                response.getWriter().write("保存成功：" + savePath + "内容 = "+json);
	            }
	          
	          
	        } catch (SmartUploadException e) {
	            e.printStackTrace();
	            System.out.println("保存失败！");
	         
	            response.getWriter().write("保存失败！");
	        }

	    }

	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response) throws ServletException, IOException {

	    }
	}

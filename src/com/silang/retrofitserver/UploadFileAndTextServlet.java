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
	        //����utf8����
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        response.setHeader("content-type","text/html;charset=UTF-8");

	        try {
	            //��ʼ��
	            SmartUpload smartUpload = new SmartUpload();
	            smartUpload.initialize(this.getServletConfig(), request, response);
	            smartUpload.uploadInFile("utf-8");
	            //��ȡwriteOff���ݵ�json�ַ���
	            String json = smartUpload.getRequest().getParameter("content");
	            System.out.println("content:" + json);
	           
	            //��ȡ�ļ���Ϣ������
	            Files files = smartUpload.getFiles();
	            for (int i = 0; i < files.getCount(); i++) {
	                com.jspsmart.upload.File file = files.getFile(i);
	                System.out.println("fileName:" + file.getFileName());
	                System.out.println("fieldName:" + file.getFieldName());
	           
	                //��ȡ����ַ���
	                String name = UUID.randomUUID().toString();
	                //����·��
	                String savePath = this.getServletContext().getRealPath("WEB-INF") + "/" + name + ".jpg";
	                //����
	                file.saveAs(savePath);
	                System.out.println("����ɹ���" + savePath);
	                response.getWriter().write("����ɹ���" + savePath + "���� = "+json);
	            }
	          
	          
	        } catch (SmartUploadException e) {
	            e.printStackTrace();
	            System.out.println("����ʧ�ܣ�");
	         
	            response.getWriter().write("����ʧ�ܣ�");
	        }

	    }

	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response) throws ServletException, IOException {

	    }
	}

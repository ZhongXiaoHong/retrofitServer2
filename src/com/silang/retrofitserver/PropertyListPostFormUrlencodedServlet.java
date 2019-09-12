package com.silang.retrofitserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.silang.retrofitserver.bean.PropertyBean;
import com.silang.retrofitserver.bean.Result;
import com.silang.retrofitserver.bean.UserInfo;

/**
 * Servlet implementation class PropertyServlet
 */
@WebServlet("/PropertyListPostFormUrlencodedServlet")
public class PropertyListPostFormUrlencodedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PropertyListPostFormUrlencodedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().write("������");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		if (id != null && name != null) {
			response.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			List<PropertyBean> beans = new ArrayList<>();
			String[] descs = new String[] { "A1��801���ݻ���", "B1�����Źܲ���", "C1��������ɫ�γ���ͣ", "D1��10��߿�����", "E1���Ž�ʧ��" };

			for (int i = 0; i < descs.length; i++) {
				if (id.equals(i + 1 + "")) {
					beans.add(new PropertyBean("silang-" + i, i + 1 + "", System.currentTimeMillis(), descs[i]));
				}

			}
			response.getWriter().write(gson.toJson(new Result(beans)));
		} else {
			doGet(request, response);
		}

		/***
		 * 
		 * ���ע��request.getParameter()��request.getInputStream()��request.getReader()�����ַ������г�ͻ�ģ���Ϊ��ֻ�ܱ���һ�Ρ�
		 * ���磺
		 * ��form�����ݲ���enctype=application/x-www-form-urlencoded����ʱ����ͨ������request.getParameter()������ȡ���ݺ�
		 * �ٵ���request.getInputStream()��request.getReader()�Ѿ���ȡ�������е������ˣ���Ϊ�ڵ���
		 * request.getParameter()ʱϵͳ���ܶԱ����ύ��������������ʽ����һ��,��֮��Ȼ��
		 * 
		 * ��form�����ݲ���enctype=multipart/form-data����ʱ������request.getParameter()��ȡ�������ݣ�
		 * ��ʹ�Ѿ�������request.getParameter()����Ҳ������ͨ������request.getInputStream()��request.getReader()��ȡ���е����ݣ�
		 * ��request.getInputStream()��request.getReader()��ͬһ����Ӧ���ǲ��ܻ��ʹ�õģ�������ʹ�û����쳣�ġ�
		 * 
		 * 
		 */

	}

}

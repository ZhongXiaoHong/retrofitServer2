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

		response.getWriter().write("无数据");

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
			String[] descs = new String[] { "A1栋801电梯坏了", "B1栋大门管不了", "C1栋优良黑色轿车乱停", "D1栋10层高空抛物", "E1栋门禁失灵" };

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
		 * 最后注意request.getParameter()、request.getInputStream()、request.getReader()这三种方法是有冲突的，因为流只能被读一次。
		 * 比如：
		 * 当form表单内容采用enctype=application/x-www-form-urlencoded编码时，先通过调用request.getParameter()方法获取数据后，
		 * 再调用request.getInputStream()或request.getReader()已经获取不到流中的内容了，因为在调用
		 * request.getParameter()时系统可能对表单中提交的数据以流的形式读了一次,反之亦然。
		 * 
		 * 当form表单内容采用enctype=multipart/form-data编码时，调用request.getParameter()获取不到数据，
		 * 即使已经调用了request.getParameter()方法也可以再通过调用request.getInputStream()或request.getReader()获取表单中的数据，
		 * 但request.getInputStream()和request.getReader()在同一个响应中是不能混合使用的，如果混合使用会抛异常的。
		 * 
		 * 
		 */

	}

}

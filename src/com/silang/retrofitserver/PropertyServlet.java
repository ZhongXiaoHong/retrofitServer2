package com.silang.retrofitserver;

import java.io.IOException;
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

/**
 * Servlet implementation class PropertyServlet
 */
@WebServlet("/PropertyServlet/silang1/property")
public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PropertyServlet() {
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
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		List<PropertyBean> beans = new ArrayList<>();
		String[] descs = new String[] { "A1栋801电梯坏了", "B1栋大门管不了", "C1栋优良黑色轿车乱停", "D1栋10层高空抛物", "E1栋门禁失灵" };

		beans.add(new PropertyBean("silang-1", 1 + "", System.currentTimeMillis(), descs[0]));

		response.getWriter().write(gson.toJson(new Result(beans)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

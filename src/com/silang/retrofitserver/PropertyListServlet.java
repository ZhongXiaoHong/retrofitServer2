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
@WebServlet("/PropertyListServlet")
public class PropertyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PropertyListServlet() {
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

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		if (id == null || id == "") {
			response.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			List<PropertyBean> beans = new ArrayList<>();
			String[] descs = new String[] { "A1栋801电梯坏了", "B1栋大门管不了", "C1栋优良黑色轿车乱停", "D1栋10层高空抛物", "E1栋门禁失灵" };
			for (int i = 0; i < descs.length; i++) {
				beans.add(new PropertyBean("silang-" + i, i + 1 + "", System.currentTimeMillis(), descs[i]));
			}
			response.getWriter().write(gson.toJson(new Result(beans)));
		} else if (id != null && name != null) {
			response.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			List<PropertyBean> beans = new ArrayList<>();
			String[] descs = new String[] { "A1栋801电梯坏了", "B1栋大门管不了", "C1栋优良黑色轿车乱停", "D1栋10层高空抛物", "E1栋门禁失灵" };
			String[] names = new String[] { "silang-1", "silang-2", "silang-3", "silang-4", "silang-5" };

			for (int i = 0; i < descs.length; i++) {
				if (id.equals(i + 1 + "") && name.equals(names[i])) {
					beans.add(new PropertyBean(name, id, System.currentTimeMillis(), descs[i]));
				}

			}
			response.getWriter().write(gson.toJson(new Result(beans)));

		} else if (id != null && name == null) {
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
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String body = "";
		String line;
		while ((line = reader.readLine()) != null) {
			body += line;
		}
		reader.close();
		try {
			UserInfo mUserInfo = new Gson().fromJson(body, UserInfo.class);
			if (mUserInfo != null) {

				String id = mUserInfo.getId();
				String name = mUserInfo.getName();

				if (id != null && name != null) {
					response.setCharacterEncoding("UTF-8");
					Gson gson = new Gson();
					List<PropertyBean> beans = new ArrayList<>();
					String[] descs = new String[] { "A1栋801电梯坏了", "B1栋大门管不了", "C1栋优良黑色轿车乱停", "D1栋10层高空抛物", "E1栋门禁失灵" };
					String[] names = new String[] { "silang-1", "silang-2", "silang-3", "silang-4", "silang-5" };

					for (int i = 0; i < descs.length; i++) {
						if (id.equals(i + 1 + "") && name.equals(names[i])) {
							beans.add(new PropertyBean(name, id, System.currentTimeMillis(), descs[i]));
						}

					}
					response.getWriter().write(gson.toJson(new Result(beans)));

				}
			}
		} catch (Exception e) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if (id != null && name == null) {
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
			}else {
				doGet(request, response);
			}
			
			
		}

	}

}

package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.UserDao;
import org.study.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDao dao = new UserDao();
		
		User user = dao.authenticateUser(id, pw);
		System.out.println("id: " + id + " pw: " + pw);
		// 인증
		if (user != null) {	// 인증 성공
			System.out.println("login success: " + user.getName());
			response.sendRedirect("apply");
		} else {
			request.setAttribute("error", "주어진 정보가 맞지않습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
}

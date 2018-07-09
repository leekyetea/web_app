package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		// 인증
		if (pw.equals("servlet")) {
			request.setAttribute("user", id);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "잘못된 ID/Password 를 입력하였습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}

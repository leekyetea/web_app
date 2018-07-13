package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
			request.setAttribute("user", id);

			//request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/profile");
		} else {
			request.setAttribute("error", "잘못된 ID/Password 를 입력하였습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}

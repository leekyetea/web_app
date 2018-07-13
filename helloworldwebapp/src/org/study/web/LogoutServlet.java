package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet  {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Cookie cookie = new Cookie("id", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		//request.setAttribute("error", "성공적으로 로그아웃 되었습니다.");
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/index.jsp?msg=logout");
	}
}

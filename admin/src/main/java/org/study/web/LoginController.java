package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 인증
		if (false) {	// 인증 성공
			request.getRequestDispatcher("").forward(request, response);
		} else {
			request.setAttribute("error", "주어진 정보가 맞지않습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
}

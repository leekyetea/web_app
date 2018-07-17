package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.model.User;

@WebServlet("/apply")
public class ApplyFormController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
		
		/*if (user != null) {
			request.setAttribute("name", user.getName());
			request.getRequestDispatcher("/WEB-INF/views/applyForm.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "먼저 로그인 하세요");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}*/
		
		request.getRequestDispatcher("/WEB-INF/views/applyForm.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
	}
}

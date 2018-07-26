package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.ApplyDao;
import org.study.model.Application;
import org.study.model.User;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	// Web application 기본동작
	// CRUD 
	// C: create
	// R: Read
	// U: Update
	// D: Delete
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ApplyDao dao = new ApplyDao();
		Application[] applys = dao.getApplications(user.getId());
		
		request.setAttribute("application", applys);
		request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
	}
}

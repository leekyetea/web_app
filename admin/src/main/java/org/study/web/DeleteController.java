package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.ApplyDao;
import org.study.dao.UserDao;
import org.study.model.Application;
import org.study.model.User;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		if (request.getParameter("id") == null) {
			request.setAttribute("error", "잘못된 호출입니다");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id <= 0) {
			request.setAttribute("error", "잘못된 호출입니다(id <= 0)");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		System.out.println("id: " + id);
		
		ApplyDao dao = new ApplyDao();
		if (dao.deleteApplication(id)) {
			request.setAttribute("del_msg", "success");
		} else {
			request.setAttribute("del_msg", "failure");
		}
		
		Application[] applys = dao.getApplications(user.getId());		
		request.setAttribute("applys", applys);
		
		request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
	}
}

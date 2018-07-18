package org.study.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.ApplyDao;
import org.study.model.Application;
import org.study.model.Country;
import org.study.model.User;

@WebServlet("/apply")
public class ApplyController extends HttpServlet {

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
		String major = request.getParameter("major");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Application application = new Application(user.getId());

		application.setMajor(major);
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			application.setDob(dateFormat.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		application.setEmail(email);
		application.setCountry(Country.getCountry(country));
		
		//System.out.println(application);
		
		ApplyDao dao = new ApplyDao();
		if (dao.submitApplication(application)) {
			response.sendRedirect(request.getContextPath() + "/profile?msg=success");
		} else {
			request.setAttribute("error", "지원서 제출 실패하였습니다");
			request.getRequestDispatcher("WEB-INF/views/applyForm.jsp").forward(request, response);
		}
	}
}

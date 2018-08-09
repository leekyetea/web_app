package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.MemberDao;
import org.study.model.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateMember")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id != null) {
			MemberDao dao = new MemberDao();
			Member member = dao.getMember(id);
			
			request.setAttribute("member", member);
		} else {
			request.setAttribute("member", null);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/updateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setDob(java.sql.Date.valueOf(dob));
		member.setEmail(email);
		
		MemberDao dao = new MemberDao();
		if (dao.updateMember(member)) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "success");
			//response.sendRedirect(request.getContextPath() + "/list?msg=success");
			response.sendRedirect(request.getContextPath() + "/list");
		} else {
			request.setAttribute("member", member);
			request.setAttribute("error", "정보 수정에 실패했습니다");
			request.getRequestDispatcher("/WEB-INF/views/updateForm.jsp").forward(request, response);
		}
	}

}

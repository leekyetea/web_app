package org.study.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.MemberDao;
import org.study.model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao dao = new MemberDao();
		Member[] members = dao.listMember();
		
		request.setAttribute("members", members);
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request,response);
	}

}

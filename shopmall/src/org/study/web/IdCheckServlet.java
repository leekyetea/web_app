package org.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.MemberDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/idcheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		// database 해당 id의 중복성 체크..
		MemberDao dao = new MemberDao();
		if (dao.existId(id)) {
			out.print("no");
		} else {
			out.print("ok");
		}
	}

}

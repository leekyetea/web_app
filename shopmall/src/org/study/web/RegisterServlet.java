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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP가 view(화면)을 그리도록 요청
		// parameters vs. attributes
		// parameters : client(html/browser) <--> servers (jps/servlet)
		// attributes : servers(servlet/jsp) <--> servers (servlet/jsp)
		// attributes examples: database에서 정보를 추출해서... 이 정보를... --> jsp

		request.setAttribute("msg", "abcde");
		request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setDob(Date.valueOf(dob));
		member.setEmail(email);
		
		// 데이터베이스에 정보를 저장
		MemberDao dao = new MemberDao();
		if (dao.insertMember(member)) {		// 회원 조회 페이지로 
			
		} else {	// 다시 등록페이지로 
			request.setAttribute("error", "등록이 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request, response);
		}
	}

}

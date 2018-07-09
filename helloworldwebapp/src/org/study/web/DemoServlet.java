package org.study.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br/>");
		response.getWriter().append("doGet 호출...");*/
		
		// 사용자에게 보여줘야 하는 페이지를 동적으로 생성
		// 정보?? 얻어오는 / 만드는 / 조작하는 
		//   db에 접속해서. 정보를 얻어옴
		// 얻어온 정보를 모양(html)을 만들어야 함
		request.setAttribute("message", "msg from demo servlet");
		request.getRequestDispatcher("demo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

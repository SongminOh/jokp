package jokp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jokp.model.RepleDAO;
import jokp.model.UserDAO;
import jokp.model.UsersVO;

/**
 * Servlet implementation class RepleInsertController
 */
@WebServlet("/repleinsert")
public class RepleInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("id");
		String reple_content = request.getParameter("reple");
		String media_id = request.getParameter("media_id");
		RepleDAO dao = new RepleDAO();
		int cnt = dao.repleInsert(user_id, media_id, reple_content);
		
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			response.sendRedirect("/2차프로젝트/재생.jsp");
			out.print("성공 *^ㅡ^*");
		}else {
			//실패
			out.print("댓글작성실패");
		}
		
		
	}

}

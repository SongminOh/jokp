package jokp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jokp.model.UserDAO;
import jokp.model.UsersVO;

@WebServlet("/preferenceset")
public class UserPreferenceSetController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("id");
		String preference = request.getParameter("pre");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		// Model°ú ¿¬µ¿(DAO)
		UserDAO dao = new UserDAO();
		UsersVO vo = new UsersVO();
		vo.setUser_id(user_id);
		vo.setPreference(preference);
		int cnt = dao.preferenceUpdate(vo);
	
		out.print(preference);
	
	}

}

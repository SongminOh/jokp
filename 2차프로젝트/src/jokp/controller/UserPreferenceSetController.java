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
		UserDAO dao = new UserDAO();
		String user_id = request.getParameter("user_id");
		String preference = request.getParameter("preference");
		String set_time = request.getParameter("set_time");
		
		
		UsersVO vo = dao.userinfoList(user_id);
		vo.setSet_time(set_time);
		vo.setPreference(preference);
		
		
		int cnt = dao.preferenceUpdate(vo);
		cnt = dao.settimeUpdate(vo);
		response.sendRedirect("/jokp/main.jsp");
	
	}

}

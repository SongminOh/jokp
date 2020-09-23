package jokp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jokp.model.UserDAO;
import jokp.model.UsersVO;

@WebServlet("/timeset")
public class UserTimeSetController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		request.setCharacterEncoding("euc-kr");
		String user_id = request.getParameter("user_id");
//		System.out.println(user_id);
		String set_time = request.getParameter("set_time");
		UsersVO vo = dao.userinfoList(user_id);
		vo.setSet_time(set_time);
		int cnt = dao.settimeUpdate(vo);
		if(cnt>0) {
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("test3.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("½ÇÆÐ!");
		}
	
	}

}

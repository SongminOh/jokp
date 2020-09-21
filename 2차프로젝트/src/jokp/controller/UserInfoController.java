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


@WebServlet("/userinfo")
public class UserInfoController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String user_id = request.getParameter("user_id");
	UserDAO dao = new UserDAO();
	UsersVO vo = dao.userinfoList(user_id);
	
	PrintWriter out = response.getWriter();
	out.print(user_id);
	
	request.setAttribute("vo", vo );
	RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
	rd.forward(request, response);
	
	}

}

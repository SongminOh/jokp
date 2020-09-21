package jokp.controller;

import java.io.IOException;
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
	
	//String user_id = request.getAttribute("user_id");
	UserDAO dao = new UserDAO();
	//dao.userinfoList(user_id);
	
	}

}

package jokp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jokp.model.UserDAO;
import jokp.model.UsersVO;

 @WebServlet("/getlogin")
public class LoginController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String pw = request.getParameter("pw");
		UserDAO dao = new UserDAO();
		String checkpw = dao.login(user_id);
		
		if(pw.equals(checkpw)) {
			//회원 인증 성공! [인증 성공]후 서비스되는 페이지로 이동(servlet,jsp)
			HttpSession session = request.getSession();
			System.out.println("세션 만료시간 : " + session.getMaxInactiveInterval()+"초");
			System.out.println("세션 생성시간 : " + session.getCreationTime());
			System.out.println("세션 마지막 접속시간 : " + session.getLastAccessedTime());
			System.out.println("세션ID :" + session.getId());
//			String id = session.getId();
			//request의 객체바인딩은 한페이지만 받을수 있어서 적합하지 않다.
			session.setAttribute("user_id", user_id); //객체바인딩(session)
//			UsersVO vo = dao.userinfoList(user_id);
//			request.setAttribute("vo", vo);
			response.sendRedirect("mainpage.jsp"); 
		}else {
			//회원인증 실패! 
			System.out.println("실패!");
		}	
		
		
		
		
	}

}

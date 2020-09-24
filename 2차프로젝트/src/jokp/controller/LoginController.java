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
			//ȸ�� ���� ����! [���� ����]�� ���񽺵Ǵ� �������� �̵�(servlet,jsp)
			HttpSession session = request.getSession();
			System.out.println("���� ����ð� : " + session.getMaxInactiveInterval()+"��");
			System.out.println("���� �����ð� : " + session.getCreationTime());
			System.out.println("���� ������ ���ӽð� : " + session.getLastAccessedTime());
			System.out.println("����ID :" + session.getId());
//			String id = session.getId();
			//request�� ��ü���ε��� ���������� ������ �־ �������� �ʴ�.
			session.setAttribute("user_id", user_id); //��ü���ε�(session)
//			UsersVO vo = dao.userinfoList(user_id);
//			request.setAttribute("vo", vo);
			response.sendRedirect("mainpage.jsp"); 
		}else {
			//ȸ������ ����! 
			System.out.println("����!");
		}	
		
		
		
		
	}

}

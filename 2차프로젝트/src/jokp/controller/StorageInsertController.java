package jokp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jokp.model.StorageDAO;
import jokp.model.StorageVO;

/**
 * Servlet implementation class StorageInsertController
 */
@WebServlet("/storageinsert")
public class StorageInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id= request.getParameter("user_id");
		String media_id= request.getParameter("media_id");
		String playtime= request.getParameter("playtime");
		String visit_time= request.getParameter("visit_time");
		char upcheck = (char)Integer.parseInt(request.getParameter("like"));
		
		StorageDAO dao = new StorageDAO();
		StorageVO vo = new StorageVO(user_id, media_id, playtime, upcheck, visit_time);
		int cnt = dao.storageInsert(vo);
//		if(cnt>0) {
//			System.out.println("인서트 완료.");
//			response.sendRedirect("재생.jsp");
//		}else {
//			System.out.println("error");
//		}
	
	}

}

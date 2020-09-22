package jokp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jokp.model.MediaDAO;
import jokp.model.MediaVO;

@WebServlet("/mediasearch")
public class MediaSearchController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
	String keyword = request.getParameter("search");
	System.out.println(keyword);
	MediaDAO dao = new MediaDAO();
	ArrayList<MediaVO> list = dao.mediaSearch(keyword);
	request.setAttribute("list", list);
	RequestDispatcher rd = request.getRequestDispatcher("검색결과.jsp");
	rd.forward(request, response);
	
	}

}

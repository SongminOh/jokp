package jokp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jokp.model.RepleDAO;
import jokp.model.RepleVO;

@WebServlet("/jsonreple")
public class JsonRepleArrayController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String media_id = request.getParameter("media_id");
		RepleDAO dao = new RepleDAO();
		ArrayList<RepleVO> list = dao.repleList(media_id);
		// Json - array 변경 : Gson API이용하기!
		
		Gson g =new Gson();
		String json = g.toJson(list);
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out=response.getWriter();
		out.print(json);
	
	}

}

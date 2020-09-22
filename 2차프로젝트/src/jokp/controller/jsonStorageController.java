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

import jokp.model.StorageDAO;
import jokp.model.StorageVO;

@WebServlet("/jsonstorage")
public class jsonStorageController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		StorageDAO dao = new StorageDAO();
		ArrayList<StorageVO> list = dao.HistoryList(user_id);
		
		Gson g =new Gson();
		String json = g.toJson(list);
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out=response.getWriter();
		out.print(json);
	}

}

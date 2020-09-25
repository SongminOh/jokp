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

import jokp.model.MediaDAO;
import jokp.model.MediaVO;
@WebServlet("/jsonuserpreference")
public class JsonUserPreferenceArrayController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MediaDAO dao = new MediaDAO();
		ArrayList<MediaVO> list = dao.mediaAllList();
		ArrayList<MediaVO> prelist = null;
		// Json - array 변경 : Gson API이용하기!
		for (MediaVO value : list) {
			if(value.getTitle().contains("고양이")) {
				prelist.add(value);
			}
		}
				Gson g =new Gson();
				String json = g.toJson(prelist);
				response.setContentType("text/json;charset=euc-kr");
				PrintWriter out=response.getWriter();
				out.print(json);	
		
		
	}

}

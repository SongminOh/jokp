package jokp.controller;

import java.util.ArrayList;

import jokp.model.MediaDAO;
import jokp.model.MediaVO;

public class tester {

	public static void main(String[] args) {

		MediaDAO dao = new MediaDAO();
		ArrayList<MediaVO> list = dao.MyMediaList1("dptmf35");
		list = dao.mediaAllList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getTitle().contains("°í¾çÀÌ")) {
				System.out.println(list.get(i).getMedia_id());
			}
		}
		
		System.out.println(list.get(1));
	}

}

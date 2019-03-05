package Kr.patago.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Kr.patago.service.OmokServiceImpl;
import Kr.patago.vo.OmokVO;

@WebServlet("/mypan_jsonp")
public class MyPanJsonp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String temp = request.getParameter("pan");
		OmokServiceImpl service = OmokServiceImpl.getInstance();
		try {
			OmokVO vo = new OmokVO();
			vo.setPan(temp);
			List<OmokVO> list =service.selectListPans(vo);
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for (int i = 0; i < list.size(); i++) {
				String pan = list.get(i).getPan();
				String pan_order = list.get(i).getPan_order();
				String history = list.get(i).getHistory();
				String winner = list.get(i).getWinner();
				text+="{\"pan\" : \""+pan+"\","+
						"\"pan_order\" : \""+pan_order+"\","+
						"\"history\" : \""+history+"\","+
								"\"winner\" : \""+winner+"\"},";
			}
			if(list.size()>0){
				text=text.substring(0, text.length()-1);
			}
			out.print("myPanJsonp(");
			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			out.print(")");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package Kr.patago.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Kr.patago.service.IOmokService;
import Kr.patago.service.OmokServiceImpl;
import Kr.patago.vo.OmokVO;

@WebServlet("/myasync")
public class MyAsync extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String history = request.getParameter("history");  
		String status = request.getParameter("status");  
		System.out.println("history = "+history);
		System.out.println("status = "+status);
		
//		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		IOmokService service = OmokServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		String text_pre = "[";
		String text = "";
		String text_post = "]";
		
		
		ArrayList<OmokVO> list =new ArrayList<OmokVO>();
		
		OmokVO pvo1 = new OmokVO();
		pvo1.setHistory(history);
		ArrayList<OmokVO> historys = (ArrayList<OmokVO>) service.selectListHist(pvo1);
		for (int i = 0; i < historys.size(); i++) {
			String pan = historys.get(i).getPan();
			String pan_order = historys.get(i).getPan_order();
			
			pan_order = (Integer.parseInt(pan_order)+2)+"";
			OmokVO pvo2 = new OmokVO();
			pvo2.setPan(pan);
			pvo2.setPan_order(pan_order);
			
			ArrayList<OmokVO> nexts = (ArrayList<OmokVO>) service.selectListPanAndOrder(pvo2);
			
			if(nexts.size()>0){
				String historyNext = nexts.get(0).getHistory();
				String[] ij ={"-1","-1"};
				getIJ(history, historyNext, status, ij);
				
				OmokVO aVO = new OmokVO();
				aVO.setI(ij[0]);
				aVO.setJ(ij[1]);
				aVO.setWinner(nexts.get(0).getWinner());
				aVO.setPan(nexts.get(0).getPan());
				
				list.add(aVO);
			}
			
		}
		
		for (int i = 0; i < list.size(); i++) {
			String ii = list.get(i).getI();
			String jj = list.get(i).getJ();
			String winner = list.get(i).getWinner();
			String pan = list.get(i).getPan();
			text+="{\"i\" : \""+ii+"\","+
			"\"j\" : \""+jj+"\","+
			"\"winner\" : \""+winner+"\","+
					"\"pan\" : \""+pan+"\"},";
		}
		if(list.size()>0){
			text=text.substring(0, text.length()-1);
		}
		out.print(text_pre);
		out.print(text);
		out.print(text_post);
	}
	
	public void getIJ(String history, String historyNext, String status , String[] ij){
		int index_ij = -1;
		for (int i = 0; i < history.length(); i++) {
			String cut = history.substring(i,i+1);
			String cutN = historyNext.substring(i,i+1);
			if((!cut.equals(cutN)) && status.equals(cutN)){
				index_ij=i;
				break;
			}
		}
		int ii = (index_ij/10);
		int jj = (index_ij%10);
		ij[0] = ii + "";
		ij[1] = jj + "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

}

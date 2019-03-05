package Kr.patago.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Kr.patago.service.OmokServiceImpl;
import Kr.patago.vo.OmokVO;

@WebServlet("/myomok")
public class MyOmok extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json");
	      
	      String historys = request.getParameter("historys");   // 100개 단위로 쉼표(,)도 같이 옴
	      String winner = request.getParameter("winner");
	      
	      String[] arr_history = historys.split(",");
	      
	      OmokServiceImpl omokService = OmokServiceImpl.getInstance();
	      OmokVO maxVO = omokService.selectMax();
	      
	      String pan = maxVO.getPan();
	      
	      
	      int count = 0;
	      for(int i = 0; i < arr_history.length; i++){
	         String pan_order = (i+1) + "";
	         String history = arr_history[i];
	         
	         OmokVO pVO = new OmokVO();
	         pVO.setPan(pan);
	         pVO.setPan_order(pan_order);
	         pVO.setHistory(history);
	         pVO.setWinner(winner);
	         
	         count += omokService.insert(pVO);
	      }
	      
	      String msg = "ok" + "," + pan;
	      if(count != arr_history.length){
	         msg = "ng";
	      }
	      
	      
	      
	      PrintWriter out = response.getWriter();
	      out.print("{\"message\":\""+msg+"\"}");
	      
//	      out.flush();

	}

}

package Kr.patago.test;

import Kr.patago.service.OmokServiceImpl;
import Kr.patago.vo.OmokVO;

public class OmokTest {
	private OmokServiceImpl omokService;
	public OmokTest() {
		omokService=OmokServiceImpl.getInstance();

		OmokVO pVO = omokService.selectMax();
		System.out.println(pVO);
		
//		OmokVO vo = new OmokVO();
//		
//
//		
//		vo.setPan("1");
//		vo.setPan_order("1");
//		vo.setHistory("1");
//		vo.setWinner("1");
//		omokService.insert(vo);
	}
	public static void main(String[] args) {
		new OmokTest();
	}
}

package Kr.patago.service;

import java.util.List;

import Kr.patago.dao.OmokDaoImpl;
import Kr.patago.vo.OmokVO;

public class OmokServiceImpl implements IOmokService {

	private OmokDaoImpl dao;
	
	private static OmokServiceImpl service;
	
	private OmokServiceImpl() {
		dao = OmokDaoImpl.getInstance();
	}
	
	public static OmokServiceImpl getInstance(){
		if(service == null){
			service = new OmokServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insert(OmokVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<OmokVO> selectList() {
		return dao.selectList();
	}

	@Override
	public OmokVO selectMax() {
		return dao.selectMax();
	}

	@Override
	public List<OmokVO> selectListPan() {
		return dao.selectListPan();
	}

	@Override
	public List<OmokVO> selectListPans(OmokVO vo) {
		return dao.selectListPans(vo);
	}

	@Override
	public List<OmokVO> selectListHist(OmokVO vo) {
		return dao.selectListHist(vo);
	}

	@Override
	public List<OmokVO> selectListPanAndOrder(OmokVO vo) {
		return dao.selectListPanAndOrder(vo);
	}

}

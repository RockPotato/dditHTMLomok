package Kr.patago.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Kr.patago.vo.OmokVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class OmokDaoImpl implements IOmokDao {
	
	private static OmokDaoImpl dao;
	private SqlMapClient smc;
	
	private OmokDaoImpl() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch(IOException e) {
			System.out.println("SqlMapClient Error");
			e.printStackTrace();
		}
	}
	
	public static OmokDaoImpl getInstance() {
		if(dao==null) {
			dao=new OmokDaoImpl();
		}
		return dao;
	}

	@Override
	public int insert(OmokVO vo) {
		int cnt = 0;
		try {
			cnt=smc.update("omok.insert",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<OmokVO> selectList() {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public OmokVO selectMax() {
		OmokVO vo = null;
		try {
			vo = (OmokVO) smc.queryForObject("omok.selectMax");
		} catch (SQLException e) {
			System.out.println("여기서 에러");
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<OmokVO> selectListPan() {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectListPan");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OmokVO> selectListPans(OmokVO vo) {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectListPans",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OmokVO> selectListHist(OmokVO vo) {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectListHist",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OmokVO> selectListPanAndOrder(OmokVO vo) {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectListPanAndOrder",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

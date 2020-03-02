package kr.or.ksmart.springboot34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.mapper.GoodsMapper;


@Service
@Transactional//crud 중 한 번이라도 오류가 나면 작동을 멈추기 위해 존재.
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	public int gInsert(Goods goods){
		
		return goodsMapper.gInsert(goods);
	}
	
	public List<Goods> getGoodsList() {
		
		return goodsMapper.getGoodsList();
	}
	public Goods SelectForUpdate(String gCode) {
		
		return goodsMapper.SelectForUpdate(gCode);
	}
	public int gUpdate(Goods goods) {
		return goodsMapper.gUpdate(goods);
		
	}
	
	public int gDelete(String gCode, String mId) {
		return goodsMapper.gDelete(gCode, mId);
	}
	
	public List<Goods> getSearchGoodsList(String sk, String sv){
		
		return goodsMapper.getSearchGoodsList(sk, sv);
	}
	
}

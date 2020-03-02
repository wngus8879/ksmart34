package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;


@Mapper
public interface GoodsMapper {
	

	public int gInsert(Goods goods); //등록
	public List<Goods> getGoodsList(); //리스트
	public Goods SelectForUpdate(String gCode); //업데이트(값 가져오기)
	public int gUpdate(Goods goods);//업데이트(값 수정하기)
	public int gDelete(String gCode, String mId); //삭제
	public List<Goods> getSearchGoodsList(String sk, String sv); //검색

}

package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Board;
import kr.or.ksmart.springboot34_mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	
	public List<Member> getMemberList(); 
	public List<Member> getSearchMemberList(String sk, String sv); 
	public int mInsert(Member member); 
	public Member SelectForUpdate(String mId); 
	public int mUpdate(Member member);
	public int mDelete(String mId, String mPw); 
	
	//전체게시판
	public List<Board> getBoardList(Map<String, Object> map); 
	//전체게시판 페이징
	public int getBoardRowCount();

}

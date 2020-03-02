package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.service.MemberService;

@Controller
public class MemberController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@Autowired
	private MemberService memberService;
	
	//전체게시판
	
	@GetMapping("/boardList")
	public String getBoardList(@RequestParam(value = "currentPage", required = false, defaultValue = "1")int currentPage
							   ,Model model) {
		logger.info("currenPage :: {}", currentPage);
		
		Map<String, Object> map =memberService.getBoardList(currentPage);
		
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		
		return "boardList/boardList";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//단,이 메소드는  동시접속자가 있을시 한 접속자가 로그아웃하면 다른 모든 접속자도 전부 로그아웃되는 거임. 나중에 쿠키 관련해서 메소드가 있다 하니 참고.
		return "login/login";
	}
	
	//로그인
	@GetMapping("/login")
	public String login(@RequestParam(value="result", required = false, defaultValue = "") String result
					   ,Model model) {
		model.addAttribute("result", result);
		return "login/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam(value="mId", required = false) String mId
					   ,@RequestParam(value="mPw", required = false) String mPw
					   ,RedirectAttributes 	redirectA
					   ,HttpSession session) {
		
		System.out.println("bind test mId:"+mId);
		System.out.println("bind test mPw:"+mPw);
		
		Member member = memberService.SelectForUpdate(mId);
		//로그인 성공
		if(member !=null && mPw != null && !"".equals(mPw)
				&& mPw.equals(member.getmPw())) {
			
			session.setAttribute("SID", member.getmId());
			session.setAttribute("SNAME", member.getmName());
			session.setAttribute("SLEVEL", member.getmLevel());
			
			return "redirect:/";
		//로그인 실패	
		}else {
			redirectA.addAttribute("result", "등록된 회원이 아닙니다.");
			return "redirect:/login";
		}
			
	}
		
		
		
	
	
	//회원검색
	@PostMapping("/memberList")
	public String memberList(@RequestParam(value="sk") String sk
							,@RequestParam(value="sv", required=false) String sv
							,Model model) {
							
		System.out.println("binding test sk:" +sk);
		System.out.println("binding test sv:" +sv);
		
		List<Member> list = memberService.getSearchMemberList(sk, sv);
		model.addAttribute("memberList", list);
		
		return "mlist/memberList";
	}

	//회원삭제
	
	@GetMapping("/mDelete")
	public String mDelete(@RequestParam(value="mId", required = false) String mId
			, Model model) {
		model.addAttribute("mId", mId);
		return "mDelete/mDelete";
	}
	
	@PostMapping("/mDelete")
	public String mDelete(@RequestParam(value="mId") String mId
						 ,@RequestParam(value="mPw", required = false) String mPw
						 ,RedirectAttributes redirectA){
		Member member = memberService.SelectForUpdate(mId);
		if(mPw != null && !"".equals(mPw)
				&& mPw.equals(member.getmPw())) {
			memberService.mDelte(mId, mPw);
			return "redirect:/memberList";
			
		}else {
			redirectA.addAttribute("mId", mId);
			return "mDelete/mDelete";
			
		}
	    
		
		}
	

	@GetMapping("/memberList")
	public String getMemberList(Model model) {
	model.addAttribute("memberList", memberService.getMemberList());
		return "mlist/memberList";
	}
	

	//회원업데이트(값 수정)
	@PostMapping("/mUpdate")
	public String mUpdate(Member member) {
		System.out.println(member.toString());
		int result = memberService.mUpdate(member);
		
		return "redirect:/memberList";
	}
	
	
	//회원업데이트(값가져오기)
	@GetMapping("/mUpdate")
	public String mUpdate(@RequestParam(value="mId", required = false) String mId
			, Model model) {
		System.out.println("binding test = " + mId);
		System.out.println("binding test2" 
						 + memberService.SelectForUpdate(mId).toString());
		
		model.addAttribute("Member", memberService.SelectForUpdate(mId));
		
		return "mUpdate/mUpdate";
	}
	
	//회원가입폼
	@GetMapping("/mInsert")
	public String mInsert() {
		
		return "mInsert/mInsert";
	}
	//회원가입pro
	@PostMapping("/mInsert")
	public String mInsert(@RequestParam(value="mId", required = false) String mId, Member member){
		System.out.println("binding test = " + mId);
		System.out.println(member.toString());
		int result = memberService.mInsert(member);
		if(result>0) {
			return "redirect:/memberList";	
		}
	
		
		return "redirect:/memberList";
	}
	

}

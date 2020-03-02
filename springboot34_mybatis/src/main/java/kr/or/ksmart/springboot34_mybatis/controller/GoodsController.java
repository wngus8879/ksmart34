package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.service.GoodsService;;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
		
	//상품등록
	@GetMapping("/gInsert")
	public String gInsert() {
		
		return "gInsert/gInsert";
	}
	
	
	 //상품등록pro
	 @PostMapping("/gInsert")
	 public String gInsert(@RequestParam(value="gCode", required = false) String gCode, Goods goods){
		 
		  System.out.println("binding test = " + gCode);
		  System.out.println(goods.toString()); 
		  int result =goodsService.gInsert(goods); 
		  if(result>0) {
			  return "redirect:/goodsList";
		  }
	 
	  
	  return "redirect:/goodsList"; }
	 
	 //상품리스트
	  @GetMapping("/goodsList")
	  public String getGoodsList(Model model) {
	   
		  model.addAttribute("goodsList", goodsService.getGoodsList()); 
	   
	   return "glist/goodsList"; 
	   
	  }
	  
	  //상품 업데이트(값 불러오기)
	  @GetMapping("/gUpdate")
		public String mUpdate(@RequestParam(value="gCode", required = false) String gCode
				, Model model) {
			
			
			model.addAttribute("Goods", goodsService.SelectForUpdate(gCode));
			
			return "gUpdate/gUpdate";
		}
	  
	//상품 업데이트(값 수정)
		@PostMapping("/gUpdate")
		public String gUpdate(Goods goods) {
			int result = goodsService.gUpdate(goods);
			
			return "redirect:/goodsList";
		}
	 
     //상품삭제
		
		@GetMapping("/gDelete")
		public String gDelete(@RequestParam(value="gCode", required = false) String gCode
							 ,@RequestParam(value="gName", required = false) String gName	
							 , Model model) {
			model.addAttribute("gCode", gCode);
			model.addAttribute("gName", goodsService.SelectForUpdate(gCode).getgName());
			return "gDelete/gDelete";
		}
		
		@PostMapping("/gDelete")
		public String gDelete(@RequestParam(value="gCode") String gCode
							 ,@RequestParam(value="mId", required = false) String mId
							 ,RedirectAttributes redirectA){
			Goods goods = goodsService.SelectForUpdate(gCode);
			if(mId != null && !"".equals(mId)
					&& mId.equals(goods.getmId())) {
				goodsService.gDelete(gCode, mId);
				return "redirect:/goodsList";
				
			}else {
				redirectA.addAttribute("gCode", gCode);
				return "gDelete/gDelete";
				
			}
		    
			
			}
		
	//상품검색
		@PostMapping("/goodsList")
		public String goodsList(@RequestParam(value="sk") String sk
							   ,@RequestParam(value="sv", required=false) String sv
							   ,Model model) {
										
				
				List<Goods> list = goodsService.getSearchGoodsList(sk, sv);
				model.addAttribute("goodsList", list);
				
				return "glist/goodsList"; 
			}
	 
}

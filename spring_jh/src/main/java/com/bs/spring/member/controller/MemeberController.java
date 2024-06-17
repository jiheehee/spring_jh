package com.bs.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bs.spring.member.dto.Member;
import com.bs.spring.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor //의존성주입
@Controller
@SessionAttributes({"loginMember"})   //loginMember부분을 session부분으로 바꿈
@RequestMapping("/member")   //이렇게 하면 자동으로 앞에"/member" 이거 붙음
public class MemeberController {
	
	private final MemberService service; //의존성 주입
	private final BCryptPasswordEncoder pwencoder;
//	private Logger logger=Logger  -> 이거 대신 @Slf4j
	
	@PostMapping("/login.do")
	public String login(String userId, String pw,
			HttpSession session, Model model) { //사용자가 입력한 userId 받아옴
		Member m=service.selectMemberById(userId); //서비스 값 Member m에 넣어줌
		log.debug("{}",m);
		System.out.println(m);
		String page="";
		if(page.equals("")) throw new RuntimeException(); //checked exception
		
//		if(m!=null&&m.getPassword().equals(pw)) {
		if(m!=null&&pwencoder.matches(pw, m.getPassword())) {
			//session.setAttribute("loginMember", m);
			model.addAttribute("loginMember",m);
			page="redirect:/";
		}else {
			model.addAttribute("msg","아이디나 패스워드가 일치하지 않습니다.");
			model.addAttribute("loc","/");
			page="common/msg";
		}
		return page;
	}
	
	@GetMapping("/logout.do")
//	public String logout(HttpSession session) {
//		session.invalidate();   //invalidate()가 머에요?
	public String logout(SessionStatus session) {
		if(session.isComplete()) session.setComplete();   //isComplete()-> invalidate랑 같음		
		return "redirect:/";
	}
	
	@GetMapping("/enrollmember.do")
	public void enrollmember(@ModelAttribute("member") Member m) {}  //아무것도 안쓰면 그냥 주소대로 들어감
	
//	public void enrollmember(Member m) {
//		int no=service.joinMember(m);		
//
//		
//		return "redirect:/";
		
//	}
	
	@PostMapping("/enrollend.do")
	public String insertMember(@Validated Member m, 
			BindingResult isResult,Model model) {  //BindingResult isResult가 뭐에요?, Model model이건 또 뭐지?
		if(isResult.hasErrors()) {
			//설정한 유효성검사를 통과하지 못한 것
			return "member/enrollmember";
		}
		
		//패스워드 암호화
		String encodePw=pwencoder.encode(m.getPassword()); //Q) pwencoder.encode 이게 머에요?
		System.out.println(encodePw);
		m.setPassword(encodePw); //m에다가 encodePw넣어줌
		log.debug(encodePw);
		
		int result=service.insertMember(m);
		if(result>0) {
			return "redirect:/"; //PMG
		}else {
			model.addAttribute("msg","회원가입실패");
			model.addAttribute("loc","/member.enrollmember.do");
			return "common/msg";
		}
	}
	
	
	

}




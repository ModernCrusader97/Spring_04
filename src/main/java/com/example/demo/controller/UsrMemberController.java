package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsrMemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum,
			String email) {
		
		if (Ut.isEmptyOrNull(loginId)) {
			return ResultData.from("F-1", "loginId 입력");
		}
		if (Ut.isEmptyOrNull(loginPw)) {
			return ResultData.from("F-2", "loginPw 입력");
		}
		if (Ut.isEmptyOrNull(name)) {
			return ResultData.from("F-3", "name 입력");
		}
		if (Ut.isEmptyOrNull(nickname)) {
			return ResultData.from("F-4", "nickname 입력");
		}
		if (Ut.isEmptyOrNull(cellphoneNum)) {
			return ResultData.from("F-5", "cellphoneNum 입력");
		}
		if (Ut.isEmptyOrNull(email)) {
			return ResultData.from("F-6", "cellphoneNum 입력");
		}

		
		ResultData doJoinRd = memberService.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);
		
		if (doJoinRd.isFail()) {
			return doJoinRd;
		}
		Member member = memberService.getMemberById((int) doJoinRd.getData1());

		return ResultData.newData(doJoinRd,"이번에 회원가입 한 회원", member);
	}
	
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public ResultData doLogin(HttpSession session, String loginId, String loginPw) {
	    
	    // 1. 공백 체크
	    if (Ut.isEmptyOrNull(loginId)) return ResultData.from("F-1", "아이디를 입력해주세요.");
	    if (Ut.isEmptyOrNull(loginPw)) return ResultData.from("F-2", "비밀번호를 입력해주세요.");

	    // 2. 아이디로 회원 찾기
	    Member member = memberService.getMemberByLoginId(loginId);
	    if (member == null) {
	        return ResultData.from("F-3", Ut.f("%s(은)는 존재하지 않는 아이디입니다.", loginId));
	    }

	    // 3. 비밀번호 일치 확인
	    if (member.getLoginPw().equals(loginPw) == false) {
	        return ResultData.from("F-4", "비밀번호가 일치하지 않습니다.");
	    }

	    // 4. 세션에 로그인 정보 저장 (핵심!)
	    session.setAttribute("loginedMemberId", member.getId());

	    return ResultData.from("S-1", Ut.f("%s님 환영합니다!", "이번에 로그인 한 회원", member.getNickname()));
	}
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public ResultData doLogout(HttpSession session) {
	    
	    // 세션에서 로그인 정보 삭제
	    session.removeAttribute("loginedMemberId");

	    return ResultData.from("S-1", "로그아웃 되었습니다.");
	}
}
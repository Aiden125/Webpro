package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	
	// Member
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession session);
	public String login(String mid, String mpw, HttpSession session);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
}

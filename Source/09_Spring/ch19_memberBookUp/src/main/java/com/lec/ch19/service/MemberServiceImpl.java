package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.inConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession session) {
		// member.getMname()에게 메일보내기, member inset, session에 mid attribute 추가하기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin:0 auto; text-align:center;\">\n" + 
					"<h1 style=\"color:blue;\">"+member.getMname()+"님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>감사쿠폰 드립니다</p>\n" + 
					"		<p>\n" + 
					"			<!-- 이미지 넣고 싶으면 이미지 주소 그대로 -->\n" + 
					"			<img src=\"http://localhost:8090/ch19/img/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"		<img src=\"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png\">\n" + 
					"	</div>\n" + 
					"	<p>서울시 강남구 강남대로</p>\n" + 
					"</div>";

			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail())); // 받는 메일
				mimeMessage.setFrom(new InternetAddress("mungml1995@gmail.com")); // 보내는 메일
				mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다(쿠폰동봉)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message); // 메일 발송
		session.setAttribute("mid", member.getMid()); // 세션에 id 속성 추가
		return memberDao.joinMember(member); // member insert
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession session) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다";
		}else if(! mpw.equals(member.getMpw())){
			result = "비밀번호를 확인하세요";
		}else {
			// 로그인 성공
			session.setAttribute("member", member);
			session.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member getetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}

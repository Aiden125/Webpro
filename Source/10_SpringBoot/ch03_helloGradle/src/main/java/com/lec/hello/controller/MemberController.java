package com.lec.hello.controller;

import com.lec.hello.domain.Member;
import com.lec.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("greeting", "안녕하세요 회원 기능입니다.");
        return "home";
    }

    @GetMapping("/join")
    public String joinView(){
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String join(Member member){
        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("memberList", memberService.list());
        return "member/list";
    }
}

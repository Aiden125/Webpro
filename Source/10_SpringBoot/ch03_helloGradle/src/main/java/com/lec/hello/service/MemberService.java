package com.lec.hello.service;

import com.lec.hello.domain.Member;
import com.lec.hello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public void save(Member member){
        memberRepository.save(member);
    }
    public List<Member> list(){
        return memberRepository.list();
    }
}

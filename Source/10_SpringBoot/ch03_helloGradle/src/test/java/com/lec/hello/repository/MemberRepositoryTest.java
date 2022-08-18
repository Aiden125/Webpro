package com.lec.hello.repository;

import com.lec.hello.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {
    private MemberRepository memberRepository = new MemberRepository();

    @AfterEach
    public void aftereach(){
        memberRepository.clear();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("홍길동");
        memberRepository.save(member);
        
        Member member1 = new Member();
        member1.setName("신길동");
        memberRepository.save(member1);
        
        List<Member> result = memberRepository.list(); // 회원 목록
        // System.out.println(result);
        Assertions.assertEquals(result.get(0), member);
        Assertions.assertEquals(result.get(1), member);

    }

    @Test
    public void list(){
        Member member = new Member();
        member.setName("홍길동");
        memberRepository.save(member);
        Member member1 = new Member();
        member1.setName("홍길동");
        memberRepository.save(member1);
        List<Member> result = memberRepository.list();
        Assertions.assertEquals(result.size(), 2);
    }



}

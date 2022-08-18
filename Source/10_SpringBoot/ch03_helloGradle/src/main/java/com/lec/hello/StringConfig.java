package com.lec.hello;

import com.lec.hello.repository.MemberRepository;
import com.lec.hello.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {
    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepository();
    }
    @Bean
    public MemberService memberService(){
        return new MemberService();
    }
}

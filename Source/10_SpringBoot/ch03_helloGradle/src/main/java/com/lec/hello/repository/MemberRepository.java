package com.lec.hello.repository;

import com.lec.hello.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// @Repository
public class MemberRepository {
    private static List<Member> store = new ArrayList<>();
    private static  int cnt=0;;
    public void save(Member member){
        member.setNo(++cnt);
        store.add(member);
    }

    public List<Member> list(){
        return store;
    }

    public void clear(){
        store.clear(); // ArrayList 지우기
    }

}

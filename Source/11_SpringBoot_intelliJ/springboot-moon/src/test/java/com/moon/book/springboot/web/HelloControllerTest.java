package com.moon.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트 진행 시 Junit에 내장된 실행자 외에 다른 실행자를 실행
@WebMvcTest(controllers = HelloController.class) // Web(Spring MVC)에 집중할 수 있도록 돕는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입 받는다.
    private MockMvc mvc; // 웹 API 테스트 시 사용, MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET을 요청
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증 (200, 404, 500) 등 검증
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검토(여기선 hello 리턴이 맞는지)
    }

}

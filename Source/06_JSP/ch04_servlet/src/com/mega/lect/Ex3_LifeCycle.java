package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet("/Ex3")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex3_LifeCycle() {
    	//객체가 메모리 안착될때(생성될때) 실행
    	System.out.println("Ex3_LifeCycle 생성자 - 1");
    }
    @PostConstruct
    public void postConstruct(){
    	System.out.println("Ex3_LifeCycle 서블릿 객체가 생성되었을 때 수행 -1");
    }

	public void init(ServletConfig config) throws ServletException {
		// 객체 생성될 때 최초 1번 수행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 생성되었을 때 수행 -2");
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청이 들어왔을 때 수행(service메소드가 있으면 doGet/doPost() 실행 안됨.
		System.out.println("service() 실행");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>service() 실행</h2>");
		out.close();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청이 get방식으로 들어왔을 때 수행(하지만 service함수가 있을 때는 실행x)
		System.out.println("doGet() 실행");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>doGet() 실행</h2>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청이 post방식으로 들어왔을 때 수행(하지만 service함수가 있을 때는 실행x)
		System.out.println("doPost() 실행");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>doPost() 실행</h2>");
		out.close();
	}
	public void destroy() {
		// Ex3_LifeCycle 서블릿이 메모리 해제될 때
		System.out.println("destroy() 실행(메모리 해제) - 1");
	}
	@PreDestroy
	private void preDestory() {
		System.out.println("destroy() 실행(메모리 해제) -2");
	}
}

package com.lec.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int readcount;
	private String pw;
	private int ref;
	private int re_step;
	private int re_indent;
	private String ip;
	private Timestamp rDate;
	
	public BoardDto() { //빈태그 쓸 때 필수
	}
	
	public BoardDto(int num, String writer, String subject, String content, String email, int readcount, String pw,
			int ref, int re_step, int re_indent, String ip, Timestamp rDate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.readcount = readcount;
		this.pw = pw;
		this.ref = ref;
		this.re_step = re_step;
		this.re_indent = re_indent;
		this.ip = ip;
		this.rDate = rDate;
	}
	
	//세터는 빈 태그 때문에 필요
	//게터는 게시글 쓸 때
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_indent() {
		return re_indent;
	}
	public void setRe_indent(int re_indent) {
		this.re_indent = re_indent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	
	@Override
	public String toString() {
		return "BoardDto [content=" + content + ", email=" + email + ", ip=" + ip + ", num=" + num + ", pw=" + pw
				+ ", rDate=" + rDate + ", re_indent=" + re_indent + ", re_step=" + re_step + ", readcount=" + readcount
				+ ", ref=" + ref + ", subject=" + subject + ", writer=" + writer + "]";
	}
	
}
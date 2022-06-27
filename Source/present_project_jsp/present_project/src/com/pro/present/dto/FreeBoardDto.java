package com.pro.present.dto;

import java.sql.Date;

public class FreeBoardDto {
	private int bno;
	private String mid;
	private int mbti;
	private String btitle;
	private String bcontent;
	private String bfilename;
	private Date brdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private int blike;
	private String bip;
	private int banswercount;
	private int bdeletemark;
	private String mname;
	private String mbtiname;
	private String levelname;
	
	public FreeBoardDto() {
	}
	public FreeBoardDto(int bno, String mid, int mbti, String btitle, String bcontent, String bfilename, Date brdate,
			int bhit, int bgroup, int bstep, int bindent, int blike, String bip, int banswercount, int bdeletemark) {
		this.bno = bno;
		this.mid = mid;
		this.mbti = mbti;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfilename = bfilename;
		this.brdate = brdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.blike = blike;
		this.bip = bip;
		this.banswercount = banswercount;
		this.bdeletemark = bdeletemark;
	}
	public FreeBoardDto(int bno, String mid, int mbti, String btitle, String bcontent, String bfilename, Date brdate,
			int bhit, int bgroup, int bstep, int bindent, int blike, String bip, int banswercount, int bdeletemark,
			String mname, String mbtiname, String levelname) {
		this.bno = bno;
		this.mid = mid;
		this.mbti = mbti;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfilename = bfilename;
		this.brdate = brdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.blike = blike;
		this.bip = bip;
		this.banswercount = banswercount;
		this.bdeletemark = bdeletemark;
		this.mname = mname;
		this.mbtiname = mbtiname;
		this.levelname = levelname;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMbti() {
		return mbti;
	}
	public void setMbti(int mbti) {
		this.mbti = mbti;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfilename() {
		return bfilename;
	}
	public void setBfilename(String bfilename) {
		this.bfilename = bfilename;
	}
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public int getBanswercount() {
		return banswercount;
	}
	public void setBanswercount(int banswercount) {
		this.banswercount = banswercount;
	}
	public int getBdeletemark() {
		return bdeletemark;
	}
	public void setBdeletemark(int bdeletemark) {
		this.bdeletemark = bdeletemark;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbtiname() {
		return mbtiname;
	}
	public void setMbtiname(String mbtiname) {
		this.mbtiname = mbtiname;
	}
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	@Override
	public String toString() {
		return "FreeBoardDto [bno=" + bno + ", mid=" + mid + ", mbti=" + mbti + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bfilename=" + bfilename + ", brdate=" + brdate + ", bhit=" + bhit + ", bgroup=" + bgroup
				+ ", bstep=" + bstep + ", bindent=" + bindent + ", blike=" + blike + ", bip=" + bip + ", banswercount="
				+ banswercount + ", bdeletemark=" + bdeletemark + ", mname=" + mname + ", mbtiname=" + mbtiname
				+ ", levelname=" + levelname + "]";
	}
	
}

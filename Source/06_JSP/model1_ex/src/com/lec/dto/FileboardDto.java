package com.lec.dto;

import java.sql.Date;

public class FileboardDto {
	private int fnum;
	private String cid;
	private String fsubject;
	private String fcontent;
	private String ffilename;
	private String fpw;
	private int fhit;
	private int fref;
	private int fre_step1;
	private int fre_level;
	private String fip;
	private Date frdate;
	private String cname;
	private String cemail;
	
	
	public FileboardDto() { }

	public FileboardDto(int fnum, String cid, String fsubject, String fcontent, String ffilename, String fpw,
			String fip, int fhit, int fref, int fre_step1, int fre_level, Date frdate) {
		super();
		this.fnum = fnum;
		this.cid = cid;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fpw = fpw;
		this.fip = fip;
		this.fhit = fhit;
		this.fref = fref;
		this.fre_step1 = fre_step1;
		this.fre_level = fre_level;
		this.frdate = frdate;
	}
	





	public FileboardDto(int fnum, String cid, String fsubject, String fcontent, String ffilename, String fpw,
			String fip, int fhit, int fref, int fre_step1, int fre_level, Date frdate, String cname, String cemail) {
		super();
		this.fnum = fnum;
		this.cid = cid;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fpw = fpw;
		this.fip = fip;
		this.fhit = fhit;
		this.fref = fref;
		this.fre_step1 = fre_step1;
		this.fre_level = fre_level;
		this.frdate = frdate;
		this.cname = cname;
		this.cemail = cemail;
	}






	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFsubject() {
		return fsubject;
	}
	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFpw() {
		return fpw;
	}
	public void setFpw(String fpw) {
		this.fpw = fpw;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public int getFref() {
		return fref;
	}
	public void setFref(int fref) {
		this.fref = fref;
	}
	public int getFre_step1() {
		return fre_step1;
	}
	public void setFre_step1(int fre_step1) {
		this.fre_step1 = fre_step1;
	}
	public int getFre_level() {
		return fre_level;
	}
	public void setFre_level(int fre_level) {
		this.fre_level = fre_level;
	}
	public Date getFrdate() {
		return frdate;
	}
	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmail() {
		return cemail;
	}
	public void setCmail(String cmail) {
		this.cemail = cmail;
	}

	public String getFfilename() {
		return ffilename;
	}



	public String getFip() {
		return fip;
	}






	public void setFip(String fip) {
		this.fip = fip;
	}






	public String getCemail() {
		return cemail;
	}






	public void setCemail(String cemail) {
		this.cemail = cemail;
	}






	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}


	

}

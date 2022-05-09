package com.lec.ex4_supermarket;
//cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, forLEVELUP
//입력, 수정, 삭제는 dto안씀
//출력할 때만 dto씀
public class CustomerDto {
	
	// 필요데이터 정의
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelName;
	private int forLevelUp;
	
	//생성자 정의
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int camount, String levelName,
			int forLevelUp) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelName = levelName;
		this.forLevelUp = forLevelUp;
	}
	
	@Override
	public String toString() {
		return cid+"\t"+ctel+"\t\t"+cname+"\t"+cpoint+"\t"+
				camount+"\t"+levelName+"\t"+forLevelUp;
	}
	
	
	// getter만 가져와도 된다는데 왜??
	public int getCid() {
		return cid;
	}

	public String getCtel() {
		return ctel;
	}

	public String getCname() {
		return cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public int getCamount() {
		return camount;
	}

	public String getLevelName() {
		return levelName;
	}

	public int getForLevelUp() {
		return forLevelUp;
	}
	
}

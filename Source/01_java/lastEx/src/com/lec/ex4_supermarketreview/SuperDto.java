package com.lec.ex4_supermarketreview;
// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
public class SuperDto {
	
	//필요한 모든 데이터 정의하기.
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelName;
	private int forLevelUp;
	
	//생성자 정의
	public SuperDto(int cid, String ctel, String cname, int cpoint, int camount, String levelName, int forLevelUp) {
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
		return cid+"\t"+ctel+"\t\t"+cname+"\t"+cpoint+"\t"+camount+"\t"+levelName+"\t"+forLevelUp;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getForLevelUp() {
		return forLevelUp;
	}

	public void setForLevelUp(int forLevelUp) {
		this.forLevelUp = forLevelUp;
	}

}

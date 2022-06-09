package st07_oop;
//사각형 가로 세로 넓이 구하기
//데이터(private)-width/height, 메소드(public)-area(), setter&getter
//Rect r1 = new Rect()
public class Rect{
	//데이터
	private int width;
	private int height;
	
	//메소드
	public int area() {
		return width*height;
	}
	
	//setter&getter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}


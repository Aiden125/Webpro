package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

//재고입력 사용자가 n을 입력할 때까지. 상품, 가격, 재고량을 입력받아 파일 출력(메모장에서 보이지 않는 데이터파일로 받아서 하는게 목적)
public class Ex03_ProductWrite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			//같은 패키지에 새로 만드는법이고 true를 안하면 이전데이터가 날아갈 수 있기에 꼭 넣기
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("입력할 재고가 더 있습니까?(Y/N)");
				answer = sc.next();
				if(answer.equalsIgnoreCase("n")) {
					break;
				}else if(answer.equalsIgnoreCase("y")) { //상품명, 가격, 재고량을 파일로 출력
					System.out.println("상품명은?");
					dos.writeUTF(sc.next()); //이렇게하면 바로 dos에 받은 값을 스트링으로 저장할 수 있음
					System.out.println("가격은?");
					dos.writeInt(sc.nextInt());
					System.out.println("재고수량은?");
					dos.writeInt(sc.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) {
					dos.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e) {
				
			}
		}
	}
}

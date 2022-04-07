package com.lec.ex1_awt;
// GUI 간단한 아이디, 비밀번호를 활용한 로그인창
// 1. 데이터 정의(라벨 - 아이디, 비밀번호 라고 쓰여져 있는 / 텍스트 필드(아이디, 비번 / 로그인버튼)
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login extends Frame{
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	
	public Ex02Login(String title) { // Frame에 컴포넌트(버튼, 텍스트박스 등등) 추가하고 화면 보이게 하기 위함
		super(title);
		// Frame의 기본 레이아웃 타입 : BorderLayout(동, 서, 남, 북, CENTER 이렇게 나눠져 있음)
		// 						FlowLayout(왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 add)
		//						GridLayout(몇행몇열)
		
		//Frame의 레이아웃 세팅
		setLayout(new FlowLayout()); 
		lbl1 = new Label("아이디");
		txtId = new TextField("ID", 20);
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); //비밀번호 *로 변경
		btnLogin = new Button("LOGIN");
		
		//add는 위 순서와 같은 순서로 정의. 메모리에 쌓이게됨
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		
		//화면으로 출력
		setSize(new Dimension(300, 150)); //창 사이즈
		setLocation(200, 100); //어디에 띄울지
		setVisible(true);
		setResizable(false); //사용자가 size 조정 불가
		
		//x클릭시 종료 awt에서는 어디서나 똑같이 들어가는 부
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); //안보이게
				dispose(); //컴포넌트 자원들 해제
				System.exit(0); //강제종료
			}
		});
		//여기까지
		
		
	}
	public Ex02Login() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02Login("Login");
	}
}

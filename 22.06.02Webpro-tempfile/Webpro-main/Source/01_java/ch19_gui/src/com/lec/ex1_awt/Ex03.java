package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//변수 선언 , 생성자에서 레이아웃 요소 넣기, 이벤트 발생 등
public class Ex03 extends Frame implements ActionListener{
	//변수 선언
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;
	
	//layout셋팅, 컴포넌트 생성 후 add, setVisible, setSize
	public Ex03() { //타이틀이 없어도 될 때
		//Frame 기본이 BorerLayout이기 때문에 setLayout(new BorderLayout()); 안해줘도 됨
		panel = new Panel(); //panel의 기본은 이기에 panel = new Panel(new FlowLayout()); 과 가틍ㅁ
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		
		//add해주기
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 100);
		
		//x클릭시 종료 awt에서는 어디서나 똑같이 들어가는 부분
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						setVisible(false); //안보이게
						dispose(); //컴포넌트 자원들 해제
						System.exit(0); //강제종료
					}
				});
				// 이벤트 추가 1. implements ActionListener -> override
				//			2. 이벤트 리스너 추가
				//			3. override된 메서드 안에다가 로직추가
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	public Ex03(String title) { //타이틀을 넣고 싶을 때
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == (btnOk)) { // ok버튼 클릭시 할 로직 : txtField의 텍스트를 list에 추가
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
		}else if(e.getSource() == btnExit) { //종료 로직
			setVisible(false); //안보이게
			dispose(); //컴포넌트 자원들 해제
			System.exit(0); //강제종료
		}
		
	}
	public static void main(String[] args) {
		new Ex03("Do you want to go home?");
	}
}

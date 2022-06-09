package com.lec.ex1_awt;
// GUI ������ ���̵�, ��й�ȣ�� Ȱ���� �α���â
// 1. ������ ����(�� - ���̵�, ��й�ȣ ��� ������ �ִ� / �ؽ�Ʈ �ʵ�(���̵�, ��� / �α��ι�ư)
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login2 extends Frame{
	private Panel panel;
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	
	public Ex02Login2(String title) { // Frame�� ������Ʈ(��ư, �ؽ�Ʈ�ڽ� ���) �߰��ϰ� ȭ�� ���̰� �ϱ� ����
		super(title);
		// Frame�� �⺻ ���̾ƿ� Ÿ�� : BorderLayout(��, ��, ��, ��, CENTER �̷��� ������ ����)
		// 						FlowLayout(���ʺ��� ����������, ������ �Ʒ��� �������� add)
		//						GridLayout(����)
		panel = new Panel(); //�г��� �⺻ ���̾ƿ� : FlowLayout
		//setLayout(new GrideLayout(2, 2));

		
		lbl1 = new Label("���̵�");
		txtId = new TextField("ID", 20);
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); //��й�ȣ *�� ����
		btnLogin = new Button("LOGIN");

		//Frame�� ���̾ƿ� ����
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280, 120)); //â ������
	
		
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		setSize(new Dimension(300, 150));
		setLocation(200, 100); //��� �����
		setVisible(true);
		setResizable(false); //����ڰ� size ���� �Ұ�
		
		//xŬ���� ���� awt������ ��𼭳� �Ȱ��� ���� ��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); //�Ⱥ��̰�
				dispose(); //������Ʈ �ڿ��� ����
				System.exit(0); //��������
			}
		});
		//�������
		
		
	}
	public Ex02Login2() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02Login2("Login");
	}
}

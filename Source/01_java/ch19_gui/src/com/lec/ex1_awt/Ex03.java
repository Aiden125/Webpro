package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//���� ���� , �����ڿ��� ���̾ƿ� ��� �ֱ�, �̺�Ʈ �߻� ��
public class Ex03 extends Frame implements ActionListener{
	//���� ����
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;
	
	//layout����, ������Ʈ ���� �� add, setVisible, setSize
	public Ex03() { //Ÿ��Ʋ�� ��� �� ��
		//Frame �⺻�� BorerLayout�̱� ������ setLayout(new BorderLayout()); �����൵ ��
		panel = new Panel(); //panel�� �⺻�� �̱⿡ panel = new Panel(new FlowLayout()); �� ���v��
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		
		//add���ֱ�
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 100);
		
		//xŬ���� ���� awt������ ��𼭳� �Ȱ��� ���� �κ�
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						setVisible(false); //�Ⱥ��̰�
						dispose(); //������Ʈ �ڿ��� ����
						System.exit(0); //��������
					}
				});
				// �̺�Ʈ �߰� 1. implements ActionListener -> override
				//			2. �̺�Ʈ ������ �߰�
				//			3. override�� �޼��� �ȿ��ٰ� �����߰�
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	public Ex03(String title) { //Ÿ��Ʋ�� �ְ� ���� ��
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == (btnOk)) { // ok��ư Ŭ���� �� ���� : txtField�� �ؽ�Ʈ�� list�� �߰�
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
		}else if(e.getSource() == btnExit) { //���� ����
			setVisible(false); //�Ⱥ��̰�
			dispose(); //������Ʈ �ڿ��� ����
			System.exit(0); //��������
		}
		
	}
	public static void main(String[] args) {
		new Ex03("Do you want to go home?");
	}
}

package com.lec.ex2_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Ex02 extends JFrame implements ActionListener{
	// �ʿ��� ������Ʈ ���� �߰�
	//private JPanel jpanel; //�����̳� ��� �� ����. �̰ɷε� ���������� �̹����� �����̳� �Ẹ��
	private Container contenPane; //�����̳� ��� �� ����
	private ImageIcon icon; //��ư�� �� icon
	private JButton jBtn; //write��ư
	private JTextField jtxtField;
	private Vector<String> items; //�޺��ڽ��� �� item����Ʈ(item�� �������� �� Vector�� ó��) 
	private String[] item = {"A", "B", "C"}; //�������� ���� String �迭�� �̷��� �� �� ����
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; //�� ��
	private JButton jBtnExit;
	
	// ������ : �����̳� ���ͼ� ���̾ƿ� ���� -> ������Ʈ ���� �� add -> setVisible, setSize(ȭ�鱸��) -> �̺�Ʈ �߰�
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x Ŭ���� ����
		contenPane = getContentPane(); // swing�� �����̳ʸ� ���� �� �۾�
		//jpanel = (JPanel) getContentPane(); �̷��Ե� ���� �гη� �����̳� �޾ƿ��� ���
		contenPane.setLayout(new FlowLayout()); //���̾ƿ� ����
		icon = new ImageIcon("icon/write.gif");
		jBtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		// jCombo = new JComboBox<String>(item); //�޺��ڽ� item ����Ʈ �߰� ��� 1.String �迭(����)
		items = new Vector<String>();
		// items �߰��� ���׵� ��������
		items.add("A"); items.add("B"); items.add("C");
		jCombo = new JComboBox<String>(items); //�޺��ڽ� item ����Ʈ �߰���� 2. vector �̿�(������)
		jCheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel("");
		jBtnExit = new JButton("Exit");
		
		// ������Ʈ add -> ������Ʈ ������ ����(pdf����)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit);
		jBtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack(); // ������Ʈ���� ������ �ּ����� ������� ����
		setLocation(100, 50);
		
		//�̺�Ʈ ������ �߰�(���� Ư�� �̺�Ʈ�� ���ϴ� ��� ����)
		jBtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { //�̺�Ʈ ���� ¥�ֱ�
		if(e.getSource() == jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if(temp.equals("")) {
				System.out.println("����"); //txtField�� ��Ʈ���̰ų� �����̽��� �Է����� ���
				return;
			}
			jCombo.addItem(temp); //�޺��ڽ��� item �߰�(items ���Ϳ� �߰��ص� �Ȱ���)
			jlBlank.setText(jtxtField.getText().trim()); //jlBlank���� jtxtField �Է� ���� �״��
			jtxtField.setText("");
		}else if(e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString(); //�޺��ڽ� ���õ� �׸�("A", "B" ...)
			int no = jCombo.getSelectedIndex();
			jlBlank.setText(no + "��°"+temp+"����");
			jCombo.setSelectedItem("A"); // "A"�� ���õǵ��� jCombo.setSelectedIndex(0);
			
		}else if(e.getSource() == jCheck) {
			if(jCheck.isSelected()) { //true�� üũ�ڽ� üũ��
				jlBlank.setText(jCheck.getText());
			}else { //false�� üũ�ڽ� ��üũ��
				jlBlank.setText("");
			}
		}else if(e.getSource() == jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Ex02(); //����
	}

}

package com.lec.ex3_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class StudentMng extends JFrame implements ActionListener {
	
	private StudentDao dao = StudentDao.getInstance();

	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtsno, txtsname, txtscore;
	
	private JButton btnsnosearch, btnsnamesearch, btnmnamesearch;
	private JButton btninput, btnupdate;
	private JButton btnstudentout, btnexpelout, btnexpel, btnexit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;
	
	private Vector<String> mnames; // �޺��ڽ��� �� ��������Ʈ�� ���� ����
	private JComboBox<String> commname;

	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // ȭ�鱸��
		contenPane.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtsno = new JTextField(10);
		txtsname = new JTextField(10);
		mnames = dao.getMnamelist();
		commname = new JComboBox<String>(mnames);
		txtscore = new JTextField(10);

		btnsnosearch = new JButton("�й��˻�");
		btnsnamesearch = new JButton("�̸��˻�");
		btnmnamesearch = new JButton("�����˻�");
		btninput = new JButton("�л��Է�");
		btnupdate = new JButton("�л�����");
		btnstudentout = new JButton("�л����");
		btnexpelout = new JButton("���������");
		btnexpel = new JButton("����ó��");
		btnexit = new JButton("����");
		txtpool = new JTextArea(10, 50);
		scrollpane = new JScrollPane(txtpool);

		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtsno);
		jpup.add(btnsnosearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtsname);
		jpup.add(btnsnamesearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(commname);
		jpup.add(btnmnamesearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtscore);

		jpbtn.add(btninput);
		jpbtn.add(btnupdate);
		jpbtn.add(btnstudentout);
		jpbtn.add(btnexpelout);
		jpbtn.add(btnexpel);
		jpbtn.add(btnexit);

		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollpane);

		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);

		btnsnosearch.addActionListener(this);
		btnsnamesearch.addActionListener(this);
		btnmnamesearch.addActionListener(this);
		btninput.addActionListener(this);
		btnupdate.addActionListener(this);
		btnstudentout.addActionListener(this);
		btnexpelout.addActionListener(this);
		btnexpel.addActionListener(this);
		btnexit.addActionListener(this);

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		// �й��˻�
		if (e.getSource() == btnsnosearch) {
			// txtSNo.getText() �� �޾� �й� �˻��Ͽ� txtSName, comMname, txtScore�� �־��ش�
			String sno = txtsno.getText().trim();
			if (sno.length() == 0) { // �й��� �Է����� ���� ���
				txtpool.setText("�й��� �Է� �� �й� �˻��ϼ���");
				txtsname.setText("");
				txtscore.setText("");
				commname.setSelectedIndex(0);
				// comMname.setSelectedItem("");
				return;
			}
			StudentDto dto = dao.selectSno(sno); // �й����� �˻��� ��� �ޱ�
			if (dto != null) { // �ش� �й��� DB�� �ִ� ���
				txtsname.setText(dto.getSname());
				commname.setSelectedItem(dto.getMname());
				// txtScore.setText(""+dto.getScore()); // ""+100 => "100"
				txtscore.setText(String.valueOf(dto.getScore()));
				txtpool.setText(sno + "�� �˻� �Ϸ�");
			} else { // �ش� �й��� DB�� ���� ���
				txtpool.setText(sno + "�� �й��� ��ȿ���� �ʽ��ϴ�");
				txtsname.setText("");
				txtscore.setText("");
				commname.setSelectedIndex(0);
			}

			// �̸��˻�
		} else if (e.getSource() == btnsnamesearch) {
			// txtSName.getText() �� �޾� �̸� �˻�
			// arraylist sizeȮ���Ͽ�, �˻��� ����� ���� ���, �Ѹ��� ���, �θ��̻� �ΰ�� ����� �ٸ���
			String sname = txtsname.getText().trim();

			// �̸��� �Է����� ���� ���
			if (sname.length() == 0) {
				txtpool.setText("�̸��� �Է� �� �̸� �˻��ϼ���");
				return;
			}
			ArrayList<StudentDto> students = dao.selectSname(sname);

			// �ش��̸��� ���� ����� ���� ��
			if (students.size() == 0) {
				System.out.println("�ش� �̸��� ���� ����� �����ϴ�.");

				// �ش� �̸��� ���� ����� �� �� �� ��
			} else if (students.size() == 1) {
				txtsno.setText(students.get(0).getSno());
				commname.setSelectedItem(students.get(0).getMname());
				txtscore.setText(String.valueOf(students.get(0).getScore()));
				txtpool.setText(sname + "�˻� �Ϸ�");

				// �ش� �̸��� ���� ����� �������� ��
			} else {
				txtpool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtpool.append("\t------------------------------------\n");
				for (StudentDto student : students) {
					txtpool.append("\t" + student.toString() + "\n");
				}
			}

			// �����˻�
			// comMname �޺��ڽ��� ���õ� �����̸����� �˻��Ͽ� ���
		} else if (e.getSource() == btnmnamesearch) {
			String mname = commname.getSelectedItem().toString();

			// �̸��� �Է����� ���� ���
			if (mname.isEmpty()) {
				txtpool.setText("������ ������ �� �˻��ϼ���");
				return;
			}
			ArrayList<StudentDto> students = dao.selectMname(mname);

			// �ش������� ���� ����� ���� ��
			if (students.size() == 0) {
				System.out.println("�ش� ������ ���� ����� �����ϴ�.");

			// �ش������� ���� ����� ���� ��
			}else {
				txtpool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtpool.append("\t------------------------------------\n");
				for (StudentDto student : students) {
					txtpool.append("\t" + student.toString() + "\n");
				}
			}
			
			
			
			
			
			// �л��Է�
			// txtSName, comMname, txtScore���� �޾� �л��Է� (txtScore�� ��ȿ�� ������ �Է����� ���� ��� ����)
		} else if (e.getSource() == btninput) { 
			String sname = txtsname.getText().trim();
			String mname = commname.getSelectedItem().toString();
			String scoreStr = txtscore.getText().trim();
			
			if(sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtpool.setText("�̸�, ����, ������ ��� �Է��ϼž� �մϴ�.");
				return;
			}
			
			int score = Integer.parseInt(scoreStr);
			
			StudentDto newstudent = new StudentDto(mname, sname, score);
			int result = dao.insertStudent(newstudent);
			if(result == StudentDao.SUCCESS) {
				txtpool.setText(sname+"�л� �Է¼���");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
			}
			
			
			
		} else if (e.getSource() == btnupdate) { // �л�����
			// sno, txtxtSName, comMname, txtScore���� �޾� �л� ����
			String sname = txtsname.getText().trim();
			String mname = commname.getSelectedItem().toString();
			String scoreStr = txtscore.getText().trim();
			String sno = txtsno.getText().trim();
			
			if(sno.equals("")||sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtpool.setText("�̸�, ����, ����, �й��� ��� �Է��ϼž� �մϴ�.");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			
			StudentDto updatestudent = new StudentDto(mname, sname, score, sno);
			int result = dao.updateStudent(updatestudent);
			if(result == StudentDao.SUCCESS) {
				txtpool.setText(sname+"�л� ���� ���� ����");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
				txtsno.setText("");
			}
			
			
			
			
			// �л����
			// �������� �ʴ� �л��� pdf�� ���� ���
		} else if (e.getSource() == btnstudentout) {
		ArrayList<StudentDto> students = dao.selectAll();
				txtpool.setText("\t���\t�̸�(�й�)\t\t�а���\t����\n");
				txtpool.append("\n");
				for(StudentDto student : students) {
					txtpool.append("\t"+student.toString()+"\n");
				}
			
			
			// ���������
			// ������ �л��� pdf�� ���� ���
		} else if (e.getSource() == btnexpelout) { 
			ArrayList<StudentDto> students = dao.selectSexpel();
			txtpool.setText("\t���\t�̸�(�й�)\t\t�а���\t����\n");
			txtpool.append("\n");
			for(StudentDto student : students) {
				txtpool.append("\t"+student.toString()+"\n");
			}

			
			
			// ����ó��
			// txtSNo�� �Էµ� �л� ����ó��
		} else if (e.getSource() == btnexpel) { 
			String sno = txtsno.getText().trim();
			StudentDto updateexpel = new StudentDto(sno);
			int result = dao.updateSexpel(updateexpel);
			if(sno.equals("")) {
				txtpool.setText("�й��� �Է��ϼž� �մϴ�.");
				return;
			}
			else if(result == StudentDao.SUCCESS) {
				txtpool.setText(sno+"�й� ����ó�� �Ϸ�");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
				txtsno.setText("");
			}
			else {
				txtpool.setText("�������� �ʴ� �й��Դϴ�");
			}
			
			
			
			// ����
		} else if (e.getSource() == btnexit) { 
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentMng("�л����");
	}
}

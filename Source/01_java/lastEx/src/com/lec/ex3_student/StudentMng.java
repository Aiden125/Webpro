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
	
	private Vector<String> mnames; // 콤보박스에 들어갈 전공리스트를 담을 벡터
	private JComboBox<String> commname;

	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // 화면구현
		contenPane.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtsno = new JTextField(10);
		txtsname = new JTextField(10);
		mnames = dao.getMnamelist();
		commname = new JComboBox<String>(mnames);
		txtscore = new JTextField(10);

		btnsnosearch = new JButton("학번검색");
		btnsnamesearch = new JButton("이름검색");
		btnmnamesearch = new JButton("전공검색");
		btninput = new JButton("학생입력");
		btnupdate = new JButton("학생수정");
		btnstudentout = new JButton("학생출력");
		btnexpelout = new JButton("제적자출력");
		btnexpel = new JButton("제적처리");
		btnexit = new JButton("종료");
		txtpool = new JTextArea(10, 50);
		scrollpane = new JScrollPane(txtpool);

		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtsno);
		jpup.add(btnsnosearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtsname);
		jpup.add(btnsnamesearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(commname);
		jpup.add(btnmnamesearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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

		// 학번검색
		if (e.getSource() == btnsnosearch) {
			// txtSNo.getText() 를 받아 학번 검색하여 txtSName, comMname, txtScore에 넣어준다
			String sno = txtsno.getText().trim();
			if (sno.length() == 0) { // 학번을 입력하지 않은 경우
				txtpool.setText("학번을 입력 후 학번 검색하세요");
				txtsname.setText("");
				txtscore.setText("");
				commname.setSelectedIndex(0);
				// comMname.setSelectedItem("");
				return;
			}
			StudentDto dto = dao.selectSno(sno); // 학번으로 검색한 결과 받기
			if (dto != null) { // 해당 학번이 DB에 있는 경우
				txtsname.setText(dto.getSname());
				commname.setSelectedItem(dto.getMname());
				// txtScore.setText(""+dto.getScore()); // ""+100 => "100"
				txtscore.setText(String.valueOf(dto.getScore()));
				txtpool.setText(sno + "번 검색 완료");
			} else { // 해당 학번이 DB에 없는 경우
				txtpool.setText(sno + "번 학번은 유효하지 않습니다");
				txtsname.setText("");
				txtscore.setText("");
				commname.setSelectedIndex(0);
			}

			// 이름검색
		} else if (e.getSource() == btnsnamesearch) {
			// txtSName.getText() 를 받아 이름 검색
			// arraylist size확인하여, 검색한 결과가 없는 경우, 한명인 경우, 두명이상 인경우 결과가 다르다
			String sname = txtsname.getText().trim();

			// 이름을 입력하지 않은 경우
			if (sname.length() == 0) {
				txtpool.setText("이름을 입력 후 이름 검색하세요");
				return;
			}
			ArrayList<StudentDto> students = dao.selectSname(sname);

			// 해당이름을 가진 사람이 없을 때
			if (students.size() == 0) {
				System.out.println("해당 이름을 가진 사람이 없습니다.");

				// 해당 이름을 가진 사람이 한 명 일 때
			} else if (students.size() == 1) {
				txtsno.setText(students.get(0).getSno());
				commname.setSelectedItem(students.get(0).getMname());
				txtscore.setText(String.valueOf(students.get(0).getScore()));
				txtpool.setText(sname + "검색 완료");

				// 해당 이름을 가진 사람이 여러명일 때
			} else {
				txtpool.setText("\t학번\t이름\t학과명\t점수\n");
				txtpool.append("\t------------------------------------\n");
				for (StudentDto student : students) {
					txtpool.append("\t" + student.toString() + "\n");
				}
			}

			// 전공검색
			// comMname 콤보박스에 선택된 전공이름으로 검색하여 출력
		} else if (e.getSource() == btnmnamesearch) {
			String mname = commname.getSelectedItem().toString();

			// 이름을 입력하지 않은 경우
			if (mname.isEmpty()) {
				txtpool.setText("전공을 선택한 후 검색하세요");
				return;
			}
			ArrayList<StudentDto> students = dao.selectMname(mname);

			// 해당전공을 가진 사람이 없을 때
			if (students.size() == 0) {
				System.out.println("해당 전공을 가진 사람이 없습니다.");

			// 해당전공을 가진 사람이 있을 때
			}else {
				txtpool.setText("\t학번\t이름\t학과명\t점수\n");
				txtpool.append("\t------------------------------------\n");
				for (StudentDto student : students) {
					txtpool.append("\t" + student.toString() + "\n");
				}
			}
			
			
			
			
			
			// 학생입력
			// txtSName, comMname, txtScore값을 받아 학생입력 (txtScore에 유효한 점수를 입력하지 않을 경우 떼끼)
		} else if (e.getSource() == btninput) { 
			String sname = txtsname.getText().trim();
			String mname = commname.getSelectedItem().toString();
			String scoreStr = txtscore.getText().trim();
			
			if(sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtpool.setText("이름, 전공, 점수를 모두 입력하셔야 합니다.");
				return;
			}
			
			int score = Integer.parseInt(scoreStr);
			
			StudentDto newstudent = new StudentDto(mname, sname, score);
			int result = dao.insertStudent(newstudent);
			if(result == StudentDao.SUCCESS) {
				txtpool.setText(sname+"학생 입력성공");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
			}
			
			
			
		} else if (e.getSource() == btnupdate) { // 학생수정
			// sno, txtxtSName, comMname, txtScore값을 받아 학생 수정
			String sname = txtsname.getText().trim();
			String mname = commname.getSelectedItem().toString();
			String scoreStr = txtscore.getText().trim();
			String sno = txtsno.getText().trim();
			
			if(sno.equals("")||sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtpool.setText("이름, 전공, 점수, 학번을 모두 입력하셔야 합니다.");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			
			StudentDto updatestudent = new StudentDto(mname, sname, score, sno);
			int result = dao.updateStudent(updatestudent);
			if(result == StudentDao.SUCCESS) {
				txtpool.setText(sname+"학생 정보 수정 성공");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
				txtsno.setText("");
			}
			
			
			
			
			// 학생출력
			// 제적되지 않는 학생들 pdf와 같이 출력
		} else if (e.getSource() == btnstudentout) {
		ArrayList<StudentDto> students = dao.selectAll();
				txtpool.setText("\t등수\t이름(학번)\t\t학과명\t점수\n");
				txtpool.append("\n");
				for(StudentDto student : students) {
					txtpool.append("\t"+student.toString()+"\n");
				}
			
			
			// 제적자출력
			// 제적된 학생들 pdf와 같이 출력
		} else if (e.getSource() == btnexpelout) { 
			ArrayList<StudentDto> students = dao.selectSexpel();
			txtpool.setText("\t등수\t이름(학번)\t\t학과명\t점수\n");
			txtpool.append("\n");
			for(StudentDto student : students) {
				txtpool.append("\t"+student.toString()+"\n");
			}

			
			
			// 제적처리
			// txtSNo에 입력된 학생 제적처리
		} else if (e.getSource() == btnexpel) { 
			String sno = txtsno.getText().trim();
			StudentDto updateexpel = new StudentDto(sno);
			int result = dao.updateSexpel(updateexpel);
			if(sno.equals("")) {
				txtpool.setText("학번을 입력하셔야 합니다.");
				return;
			}
			else if(result == StudentDao.SUCCESS) {
				txtpool.setText(sno+"학번 제적처리 완료");
				txtsname.setText("");
				commname.setSelectedIndex(0);
				commname.setSelectedItem("");
				txtscore.setText("");
				txtsno.setText("");
			}
			else {
				txtpool.setText("존재하지 않는 학번입니다");
			}
			
			
			
			// 종료
		} else if (e.getSource() == btnexit) { 
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentMng("학사관리");
	}
}

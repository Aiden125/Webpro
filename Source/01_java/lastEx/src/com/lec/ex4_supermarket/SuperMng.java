package com.lec.ex4_supermarket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class SuperMng extends JFrame implements ActionListener {
	// DAO
	CustomerDao dao = CustomerDao.getInstance();

	// 화면구현
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;

	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;

	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;

	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public SuperMng(String title) {

		// 슈퍼(타이틀)랑 x누르면 닫히는 옵션
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 컴포넌트 객체생성(컨테이너 기본=보더, 패널은 기본 플로우)
		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();

		txtCid = new JTextField(20);
		txtCtel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCamount = new JTextField(20);

		levelNames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);

		btnCidSearch = new JButton("아이디검색");
		btnCtelSearch = new JButton("폰4자리(Full)검색");
		btnCnameSearch = new JButton("고객이름검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");
		btnBuy = new JButton("물품구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCtelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// 컨테이너에 컴포넌트 배치
		jpup.add(new JLabel("아 이 디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);

		jpup.add(new JLabel("고객 전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);

		jpup.add(new JLabel("고객 이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);

		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);

		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5행 3열

		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);

		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);

		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 100);
		txtPool.setText("\t고객 검색 후 구매하세요");

		// setVisible 및 이벤트 추가
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCidSearch) { // 아이디 검색
			// cid 입력란 외에는 기본으로 비워놓고 로직 수행
			// txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());

			} catch (Exception e2) {
				// 고객 id를 안치거나 숫자를 안치거나 하면 여기로옴
				txtPool.setText("유효한 고객 ID를 입력하신 후 검색하세요");

				return;
			}
			// 숫자를 잘 넣으면 여기로 오게 됨
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if (customer != null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // 물품 구매액 넣을 예정
				comLevelName.setSelectedItem(customer.getLevelName());
				txtPool.setText("ID\t전화\t\t이름\t포인트\t누적구매액\t고객레벨\t레벨업을 위한 추가 필요 금액\n");
				txtPool.append("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("없는 ID입니다");
			}

		} else if (e.getSource() == btnCtelSearch) { // 폰4자리 검색(적어도 4글자 이상 치게)
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			// txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");

			String ctel = txtCtel.getText().trim();

			// 네자리 이하 걸러내기
			if (ctel.length() < 4) {
				txtPool.setText("적어도 4자리 이상 숫자를 입력하세요");
				return;
			}
			// 적어도 4자리 이상 전화번호를 치면 여기로 내려옴
			ArrayList<CustomerDto> customers = dao.cTelGetCustomers(ctel);

			if (customers.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t누적구매액\t고객레벨\t레벨업을 위한 추가 필요 금액\n");
				txtPool.append("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText("");
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 전화번호의 고객이 없습니다 회원가입 진행해주세요");
			}

			
			
		} else if (e.getSource() == btnCnameSearch) { // 이름 검색
			// cname 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			// txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");

			String cname = txtCname.getText().trim();

			// 두 자리 이하 걸러내기
			if (cname.length() < 2) {
				txtPool.setText("2글자 이상 입력하세요");
				return;
			}
			// 적어도 2글자 이상 이름을 치면 여기로 내려옴
			ArrayList<CustomerDto> customers = dao.cNameGetCustomers(cname);

			if (customers.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t누적구매액\t고객레벨\t레벨업을 위한 추가 필요 금액\n");
				txtPool.append("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText("");
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 이름의 고객이 없습니다 회원가입 진행해주세요");
			}

			
		// 포인트만으로 구매
		} else if (e.getSource() == btnBuyWithPoint) { 
			int cid, cpoint, camount;
			try {
				//만약 이 세개가 문제가 있는 값이면 캐치절로 빠짐
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				
				//여기까지 온건 id, point, 구매금액 문제가 없을 때
				if(cpoint < camount) {
					txtPool.setText("포인트가 부족합니다");
					return;
				}
				
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 ID, point, 구매금액을 입력하세요");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("포인트로 구매성공");
				txtCpoint.setText(String.valueOf(cpoint-camount)); // 차감된 포인트로 띄워줌
				txtCamount.setText("");
			}else {
				txtPool.setText("고객 아이디가 유효하지 않습니다.");
			}
			
			
			
		// 물품구매	
		} else if (e.getSource() == btnBuy) { 
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객ID을 마친 뒤, 구매금액을 입력후 구매하세요");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("물품 구매 완료");
				txtCpoint.setText(String.valueOf(cpoint+(int)(camount*0.05)));
				txtCamount.setText("");
			}else {
				txtPool.setText("고객 아이디가 유효하지 않습니다.");
			}
			
			
			
		} else if (e.getSource() == btnLevelNameOutput) { // 등급별 조회
			// comLevelName 콤보박스 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			//comLevelName.setSelectedItem("");

			//getSelectedItem은 오브젝트라 스트링으로 변경
			String levelName = comLevelName.getSelectedItem().toString();
			
			// 두 자리 이하 걸러내기
			if (levelName.length()==0) {
				txtPool.setText("원하는 등급을 선택하세요");
				return;
			}
			// 등급을 선택했으면 여기로 내려옴
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomers(levelName);

			if (customers.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t누적구매액\t고객레벨\t레벨업을 위한 추가 필요 금액\n");
				txtPool.append(
						"―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총 "+customers.size()+"명");
			} else {
				txtPool.setText("해당 레벨의 고객이 없습니다");
			}
			
			

		} else if (e.getSource() == btnAllOutput) { // 전체 출력
			// 모든 컴포넌트를 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			
			ArrayList<CustomerDto> customers = dao.getCustomers();

			if (customers.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t누적구매액\t고객레벨\t레벨업을 위한 추가 필요 금액\n");
				txtPool.append(
						"―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총 "+customers.size()+"명");
			} else {
				txtPool.setText("현재 등록된 고객이 없습니다");
			}
			
			
			
		} else if (e.getSource() == btnInsert) { // 회원가입
			// ctel, cname 입력란을 제외하고 빈스트링 및 초기값으로 정리
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			
			if(ctel.length()<8||cname.length()<2) {
				txtPool.setText("전화번호와 이름은 필수 입력사항입니다.");
				return;
			}
			
			//여기로 왔다는건 인서트 가능하다는것(전화번호, 이름을 넣었다는것)
			int result = dao.insertCustomer(ctel, cname); //순서주의
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText(cname+"님 회원가입 감사합니다. 포인트 1천점 지급되었습니다");
			}
			

		} else if (e.getSource() == btnCtelUpdate) { // 번호 수정
			// 아이디랑 번호를 받아서 아이디가지고 번호 수정
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("올바른 전화번호를 입력해주세요");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객ID를 입력해주세요");
				return;
			}
			
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("전화번호가 수정되었습니다");
			}else {
				txtPool.setText("유효한 고객ID로 검색 후에 수정해주세요");
			}
			
			
			
		} else if (e.getSource() == btnDelete) { // 회원탈퇴
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			// txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			
			String ctel = txtCtel.getText().trim();
			
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원탈퇴해주세요");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("회원탈퇴완료");
				txtCtel.setText("");
			}else {
				txtPool.setText("등록된 전화번호가 아니어서 회원탈퇴 진행 불가합니다");
			}
			
			
		} else if (e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SuperMng("슈퍼마켓 관리");
	}

}

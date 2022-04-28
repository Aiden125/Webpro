package test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	
	// DAO
	CustomerDao dao = CustomerDao.getInstance();

	// 화면구현
	private Container container;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;

	private JButton btnJoin, btnSearch, btnOutput, btnExit;

	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public CustomerMng(String title) {

		// 슈퍼(타이틀)랑 x누르면 닫히는 옵션
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 컴포넌트 객체생성(컨테이너 기본=보더, 패널은 기본 플로우)
		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);

		
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");

		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);

		// 컨테이너에 컴포넌트 배치
		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);

		jpup.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);

		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);

		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
	
		container.add(jpup);
		container.add(jpdown);
		container.add(scrollPane);

		setVisible(true);
		setSize(new Dimension(400, 450));
		setLocation(200, 100);
		txtPool.setText("\t원하시는 기능을 선택해주세요");

		// setVisible 및 이벤트 추가
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		//가입, 폰조회, 출력, 종료
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. 가입 : Phone, Name 입력란을 제외하고 빈스트링 및 초기값으로 정리
		if (e.getSource() == btnJoin) {
			txtPoint.setText("1000");
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();

			if (phone.length() < 8 || phone.length() < 2) {
				txtPool.setText("전화번호와 이름을 올바르게 입력해주세요.");
				return;
			}

			// 여기로 왔다는건 인서트 가능하다는것(전화번호, 이름을 넣었다는것)
			int result = dao.insertCustomer(phone, name); // 순서주의
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("\""+name+"\""+ "님 회원가입 감사합니다.\n포인트 1천점 지급되었습니다");
			}
			
		// 2. : 폰4자리 or full검색(적어도 4글자 이상 치게)
		} else if (e.getSource() == btnSearch) { 
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtName.setText("");
			txtPoint.setText("");

			String phone = txtPhone.getText().trim();

			// 네자리 이하 걸러내기
			if (phone.length() < 4) {
				txtPool.setText("적어도 4자리 이상 숫자를 입력하세요");
				return;
			}
			// 적어도 4자리 이상 전화번호를 치면 여기로 내려옴
			ArrayList<CustomerDto> customers = dao.phoneGetCustomers(phone);

			if (customers.size() == 0) { // 출력
				txtPool.setText("해당 전화번호의 고객이 없습니다 회원가입을 진행해주세요");
			} else if(customers.size() == 1){
					txtPhone.setText(customers.get(0).getPhone());
					txtName.setText(customers.get(0).getName());
					txtPoint.setText(String.valueOf(customers.get(0).getPoint()));
					txtPool.setText("1명 검색되었습니다");
			} else {
				txtPool.setText("번호\t핸드폰\t이름\t포인트\n");
				txtPool.append("――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append(customers.size()+"명 검색되었습니다.");
			}

			
			
		} else if (e.getSource() == btnOutput) { //전체출력
			// 모든 컴포넌트를 기본으로 비워놓고 로직 수행
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");

			ArrayList<CustomerDto> customers = dao.getCustomers();

			if (customers.size() != 0) { // 출력
				txtPool.setText("번호\t핸드폰\t이름\t포인트\n");
				txtPool.append("――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("현재회원수 총 : " + customers.size() + "명");
			} else {
				txtPool.setText("현재 등록된 회원이 없습니다");
			}

		} else if (e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}

}

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

	// ȭ�鱸��
	private Container container;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;

	private JButton btnJoin, btnSearch, btnOutput, btnExit;

	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public CustomerMng(String title) {

		// ����(Ÿ��Ʋ)�� x������ ������ �ɼ�
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������Ʈ ��ü����(�����̳� �⺻=����, �г��� �⺻ �÷ο�)
		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);

		
		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");

		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);

		// �����̳ʿ� ������Ʈ ��ġ
		jpup.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);

		jpup.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);

		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
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
		txtPool.setText("\t���Ͻô� ����� �������ּ���");

		// setVisible �� �̺�Ʈ �߰�
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		//����, ����ȸ, ���, ����
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. ���� : Phone, Name �Է¶��� �����ϰ� ��Ʈ�� �� �ʱⰪ���� ����
		if (e.getSource() == btnJoin) {
			txtPoint.setText("1000");
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();

			if (phone.length() < 8 || phone.length() < 2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� �ùٸ��� �Է����ּ���.");
				return;
			}

			// ����� �Դٴ°� �μ�Ʈ �����ϴٴ°�(��ȭ��ȣ, �̸��� �־��ٴ°�)
			int result = dao.insertCustomer(phone, name); // ��������
			if (result == CustomerDao.SUCCESS) {
				txtPool.setText("\""+name+"\""+ "�� ȸ������ �����մϴ�.\n����Ʈ 1õ�� ���޵Ǿ����ϴ�");
			}
			
		// 2. : ��4�ڸ� or full�˻�(��� 4���� �̻� ġ��)
		} else if (e.getSource() == btnSearch) { 
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtName.setText("");
			txtPoint.setText("");

			String phone = txtPhone.getText().trim();

			// ���ڸ� ���� �ɷ�����
			if (phone.length() < 4) {
				txtPool.setText("��� 4�ڸ� �̻� ���ڸ� �Է��ϼ���");
				return;
			}
			// ��� 4�ڸ� �̻� ��ȭ��ȣ�� ġ�� ����� ������
			ArrayList<CustomerDto> customers = dao.phoneGetCustomers(phone);

			if (customers.size() == 0) { // ���
				txtPool.setText("�ش� ��ȭ��ȣ�� ���� �����ϴ� ȸ�������� �������ּ���");
			} else if(customers.size() == 1){
					txtPhone.setText(customers.get(0).getPhone());
					txtName.setText(customers.get(0).getName());
					txtPoint.setText(String.valueOf(customers.get(0).getPoint()));
					txtPool.setText("1�� �˻��Ǿ����ϴ�");
			} else {
				txtPool.setText("��ȣ\t�ڵ���\t�̸�\t����Ʈ\n");
				txtPool.append("������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append(customers.size()+"�� �˻��Ǿ����ϴ�.");
			}

			
			
		} else if (e.getSource() == btnOutput) { //��ü���
			// ��� ������Ʈ�� �⺻���� ������� ���� ����
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");

			ArrayList<CustomerDto> customers = dao.getCustomers();

			if (customers.size() != 0) { // ���
				txtPool.setText("��ȣ\t�ڵ���\t�̸�\t����Ʈ\n");
				txtPool.append("������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("����ȸ���� �� : " + customers.size() + "��");
			} else {
				txtPool.setText("���� ��ϵ� ȸ���� �����ϴ�");
			}

		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}

}

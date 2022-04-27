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

	// ȭ�鱸��
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

		// ����(Ÿ��Ʋ)�� x������ ������ �ɼ�
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������Ʈ ��ü����(�����̳� �⺻=����, �г��� �⺻ �÷ο�)
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

		btnCidSearch = new JButton("���̵�˻�");
		btnCtelSearch = new JButton("��4�ڸ�(Full)�˻�");
		btnCnameSearch = new JButton("���̸��˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ� ����");
		btnBuy = new JButton("��ǰ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCtelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// �����̳ʿ� ������Ʈ ��ġ
		jpup.add(new JLabel("�� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);

		jpup.add(new JLabel("�� ��ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);

		jpup.add(new JLabel("�� �̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);

		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);

		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5�� 3��

		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
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
		txtPool.setText("\t�� �˻� �� �����ϼ���");

		// setVisible �� �̺�Ʈ �߰�
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
		if (e.getSource() == btnCidSearch) { // ���̵� �˻�
			// cid �Է¶� �ܿ��� �⺻���� ������� ���� ����
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
				// �� id�� ��ġ�ų� ���ڸ� ��ġ�ų� �ϸ� ����ο�
				txtPool.setText("��ȿ�� �� ID�� �Է��Ͻ� �� �˻��ϼ���");

				return;
			}
			// ���ڸ� �� ������ ����� ���� ��
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if (customer != null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // ��ǰ ���ž� ���� ����
				comLevelName.setSelectedItem(customer.getLevelName());
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t�������ž�\t������\t�������� ���� �߰� �ʿ� �ݾ�\n");
				txtPool.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("���� ID�Դϴ�");
			}

		} else if (e.getSource() == btnCtelSearch) { // ��4�ڸ� �˻�(��� 4���� �̻� ġ��)
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			// txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");

			String ctel = txtCtel.getText().trim();

			// ���ڸ� ���� �ɷ�����
			if (ctel.length() < 4) {
				txtPool.setText("��� 4�ڸ� �̻� ���ڸ� �Է��ϼ���");
				return;
			}
			// ��� 4�ڸ� �̻� ��ȭ��ȣ�� ġ�� ����� ������
			ArrayList<CustomerDto> customers = dao.cTelGetCustomers(ctel);

			if (customers.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t�������ž�\t������\t�������� ���� �߰� �ʿ� �ݾ�\n");
				txtPool.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
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
				txtPool.setText("�ش� ��ȭ��ȣ�� ���� �����ϴ� ȸ������ �������ּ���");
			}

			
			
		} else if (e.getSource() == btnCnameSearch) { // �̸� �˻�
			// cname �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			// txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");

			String cname = txtCname.getText().trim();

			// �� �ڸ� ���� �ɷ�����
			if (cname.length() < 2) {
				txtPool.setText("2���� �̻� �Է��ϼ���");
				return;
			}
			// ��� 2���� �̻� �̸��� ġ�� ����� ������
			ArrayList<CustomerDto> customers = dao.cNameGetCustomers(cname);

			if (customers.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t�������ž�\t������\t�������� ���� �߰� �ʿ� �ݾ�\n");
				txtPool.append("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
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
				txtPool.setText("�ش� �̸��� ���� �����ϴ� ȸ������ �������ּ���");
			}

			
		// ����Ʈ������ ����
		} else if (e.getSource() == btnBuyWithPoint) { 
			int cid, cpoint, camount;
			try {
				//���� �� ������ ������ �ִ� ���̸� ĳġ���� ����
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				
				//������� �°� id, point, ���űݾ� ������ ���� ��
				if(cpoint < camount) {
					txtPool.setText("����Ʈ�� �����մϴ�");
					return;
				}
				
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID, point, ���űݾ��� �Է��ϼ���");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ�� ���ż���");
				txtCpoint.setText(String.valueOf(cpoint-camount)); // ������ ����Ʈ�� �����
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�.");
			}
			
			
			
		// ��ǰ����	
		} else if (e.getSource() == btnBuy) { 
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ID�� ��ģ ��, ���űݾ��� �Է��� �����ϼ���");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ ���� �Ϸ�");
				txtCpoint.setText(String.valueOf(cpoint+(int)(camount*0.05)));
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�.");
			}
			
			
			
		} else if (e.getSource() == btnLevelNameOutput) { // ��޺� ��ȸ
			// comLevelName �޺��ڽ� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			//comLevelName.setSelectedItem("");

			//getSelectedItem�� ������Ʈ�� ��Ʈ������ ����
			String levelName = comLevelName.getSelectedItem().toString();
			
			// �� �ڸ� ���� �ɷ�����
			if (levelName.length()==0) {
				txtPool.setText("���ϴ� ����� �����ϼ���");
				return;
			}
			// ����� ���������� ����� ������
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomers(levelName);

			if (customers.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t�������ž�\t������\t�������� ���� �߰� �ʿ� �ݾ�\n");
				txtPool.append(
						"��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("�� "+customers.size()+"��");
			} else {
				txtPool.setText("�ش� ������ ���� �����ϴ�");
			}
			
			

		} else if (e.getSource() == btnAllOutput) { // ��ü ���
			// ��� ������Ʈ�� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			
			ArrayList<CustomerDto> customers = dao.getCustomers();

			if (customers.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t�������ž�\t������\t�������� ���� �߰� �ʿ� �ݾ�\n");
				txtPool.append(
						"��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("�� "+customers.size()+"��");
			} else {
				txtPool.setText("���� ��ϵ� ���� �����ϴ�");
			}
			
			
			
		} else if (e.getSource() == btnInsert) { // ȸ������
			// ctel, cname �Է¶��� �����ϰ� ��Ʈ�� �� �ʱⰪ���� ����
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			
			if(ctel.length()<8||cname.length()<2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� �ʼ� �Է»����Դϴ�.");
				return;
			}
			
			//����� �Դٴ°� �μ�Ʈ �����ϴٴ°�(��ȭ��ȣ, �̸��� �־��ٴ°�)
			int result = dao.insertCustomer(ctel, cname); //��������
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText(cname+"�� ȸ������ �����մϴ�. ����Ʈ 1õ�� ���޵Ǿ����ϴ�");
			}
			

		} else if (e.getSource() == btnCtelUpdate) { // ��ȣ ����
			// ���̵�� ��ȣ�� �޾Ƽ� ���̵����� ��ȣ ����
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("�ùٸ� ��ȭ��ȣ�� �Է����ּ���");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ID�� �Է����ּ���");
				return;
			}
			
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�");
			}else {
				txtPool.setText("��ȿ�� ��ID�� �˻� �Ŀ� �������ּ���");
			}
			
			
			
		} else if (e.getSource() == btnDelete) { // ȸ��Ż��
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			// txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			
			String ctel = txtCtel.getText().trim();
			
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�����ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("ȸ��Ż��Ϸ�");
				txtCtel.setText("");
			}else {
				txtPool.setText("��ϵ� ��ȭ��ȣ�� �ƴϾ ȸ��Ż�� ���� �Ұ��մϴ�");
			}
			
			
		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SuperMng("���۸��� ����");
	}

}

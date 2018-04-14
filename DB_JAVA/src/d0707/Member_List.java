package d0707;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener, ActionListener {
	
	Vector				v;
	Vector				cols;
	DefaultTableModel	model;
	JTable				jTable;
	JScrollPane			pane;
	JPanel				pbtn;
	JButton				btnInsert;
	
	public Member_List() {
		super("������");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList(); //���ȸ������Ʋ�� �����´�.
		System.out.println("v=" + v);
		cols = getColumn();
		
		model = new DefaultTableModel(v, cols);
		
		jTable = new JTable(model);
		btnInsert = new JButton("ȸ�����");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);
		
		jTable.addMouseListener(this);		//ȸ������Ʈ ���̺� �����ʸ� ����Ѵ�.
		btnInsert.addActionListener(this); 	//ȸ����Ϲ�ư�� �����ʸ� ����Ѵ�.
		
		setLocation(400, 200);
		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//JTable�� ��ܿ� �÷��� �̸����� �ٿ��ش�.
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("���̵�");
		col.add("��й�ȣ");
		col.add("�̸�");
		col.add("��ȭ��ȣ");
		col.add("�ּ�");
		col.add("�������");
		col.add("����");
		col.add("����");
		col.add("�̸���");
		col.add("ȸ���Ұ�");
		return col;
	}
	
	//JTable ������ ����
	public void jTableRefresh() {
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable.setModel(model);
	}
	
	public static void main(String[] args) {
		new Member_List();
	}
	
	//�߻�޼��带 �����Ѵ�.
	public void mouseClicked(MouseEvent e) {
		//ȸ������Ʈ�� �߿��� ����Ŭ���ϸ� �׿� ���� â��(MemberProc) ��Ÿ������ �Ѵ�.
		int r = jTable.getSelectedRow();	//ȸ������Ʈ���� ������ ���� ���° ������ �����´�.
		String id = (String)jTable.getValueAt(r, 0); //�ش����� ù��° �÷��� ������ �����´�(id)
		//������ id�� ������ ������â(MemberProc)�� �����Ѵ�.
		MemberProc mem = new MemberProc(id, this);
	}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited  (MouseEvent e) {}
	public void mousePressed (MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		//��ư�� Ŭ���ϸ� : ȸ����Ϲ�ư�� ������
		if(e.getSource() == btnInsert) {
			new MemberProc(this);	//�űԵ���̹Ƿ� ���ʹ� �ٸ��� ȸ��id�� ����.
		}
	}
}















































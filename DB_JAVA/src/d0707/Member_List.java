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
		super("고객관리");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList(); //모든회원리스틀을 가져온다.
		System.out.println("v=" + v);
		cols = getColumn();
		
		model = new DefaultTableModel(v, cols);
		
		jTable = new JTable(model);
		btnInsert = new JButton("회원등록");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);
		
		jTable.addMouseListener(this);		//회원리스트 테이블에 리스너를 등록한다.
		btnInsert.addActionListener(this); 	//회원등록버튼에 리스너를 등록한다.
		
		setLocation(400, 200);
		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//JTable의 상단에 컬럼의 이름들을 붙여준다.
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("이름");
		col.add("전화번호");
		col.add("주소");
		col.add("생년월일");
		col.add("직업");
		col.add("성별");
		col.add("이메일");
		col.add("회원소개");
		return col;
	}
	
	//JTable 내용을 갱신
	public void jTableRefresh() {
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable.setModel(model);
	}
	
	public static void main(String[] args) {
		new Member_List();
	}
	
	//추상메서드를 구현한다.
	public void mouseClicked(MouseEvent e) {
		//회원리스트들 중에서 선택클릭하면 그에 대한 창이(MemberProc) 나타나도록 한다.
		int r = jTable.getSelectedRow();	//회원리스트에서 선택한 것이 몇번째 줄인지 가져온다.
		String id = (String)jTable.getValueAt(r, 0); //해당줄의 첫번째 컬럼의 정보를 가져온다(id)
		//가져온 id를 가지고 상세정보창(MemberProc)을 생성한다.
		MemberProc mem = new MemberProc(id, this);
	}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited  (MouseEvent e) {}
	public void mousePressed (MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		//버튼을 클릭하면 : 회원등록버튼을 누르면
		if(e.getSource() == btnInsert) {
			new MemberProc(this);	//신규등록이므로 위와는 다르게 회원id가 없다.
		}
	}
}















































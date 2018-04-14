package d0707;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MemberDAO {

	/* Oracle
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL    = "jdbc:oracle:thin:@163.239.16.101:1521:ORCL";
	*/

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://163.239.16.101:3306/sogangdb";

	private static final String USER = "sogang";
	private static final String PASS = "sogang1234";
	
	Member_List mList;
	
	public MemberDAO() {
		
	}
	
	public MemberDAO(Member_List mList) {
		this.mList = mList;
		System.out.println("DAO=>" + mList);
	}
	
	// �����ͺ��̽��� ����
	public Connection getConn() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER); //1.����̹��� �ε��Ѵ�.
			con = DriverManager.getConnection(URL, USER, PASS);	//2.�ּ�, id, ��й�ȣ�� ������ �����Ѵ�.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//��� ȸ������Ʈ�� �˻��Ѵ�.
	public Vector getMemberList() {
		Vector data = new Vector(); //��� ȸ������ ������ ��� ���ؼ�
		
		Connection			con = null;	//�����ͺ��̽��� �����ϱ� ���ؼ�
		PreparedStatement 	ps  = null;	//����� �����ͺ��̽��� ���Ǹ� �ϱ� ���ؼ�
		ResultSet			rs  = null;	//���ǿ� ���� ������� ��� ���ؼ�
		
		try {
			con = getConn();	//�����ͺ��̽��� ����
			//���� ������ �ۼ��Ѵ�.
			//ȸ�����̺��� ��� �ڷḦ �������µ� �̸��� ������������ �����ؼ� �����´�.
			String sql = "select * from tb_member order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 	//�ۼ��� ���Ǹ� �����Ų��.
			
			while(rs.next()) {	//�����Ͱ� ���� ������ ���ѹݺ��Ѵ�.(1�Ǿ� �����´�)
				String id		= rs.getString("id");
				String pwd		= rs.getString("pwd");
				String name		= rs.getString("name");
				String tel		= rs.getString("tel");
				String addr 	= rs.getString("addr");
				String birth	= rs.getString("birth");
				String gender	= rs.getString("gender");
				String job		= rs.getString("job");
				String email	= rs.getString("email");
				String intro	= rs.getString("intro");
				
				Vector row = new Vector(); //�˻��� 1�ǿ� ���� �����͸� ��� ���ؼ�
				row.add(id);
				row.add(pwd);
				row.add(name);
				row.add(tel);
				row.add(addr);
				row.add(birth);
				row.add(job);
				row.add(gender);
				row.add(email);
				row.add(intro);
				
				data.add(row);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	} // End getMemberList()
	
	//id�� �ش��ϴ� ȸ���� ������ �˻��Ѵ�.
	public MemberDTO getMemberDTO(String id) {
		MemberDTO dto = new MemberDTO();
		
		Connection		  con = null;
		PreparedStatement ps  = null;
		ResultSet         rs  = null;
		
		try {
			con = getConn();
			String sql = "select * from tb_member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setId		(rs.getString("id"));
				dto.setPwd		(rs.getString("pwd"));
				dto.setName		(rs.getString("name"));
				dto.setTel		(rs.getString("tel"));
				dto.setAddr		(rs.getString("addr"));
				dto.setBirth	(rs.getString("birth"));
				dto.setJob		(rs.getString("job"));
				dto.setGender	(rs.getString("gender"));
				dto.setEmail	(rs.getString("email"));
				dto.setIntro	(rs.getString("intro"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	} // End getMemberDTO(String id)
	public boolean insertMember(MemberDTO dto){
		boolean ok = false;
		Connection			con = null;
		PreparedStatement	ps	= null;
		//ResultSet			rs 	= null;
		
		try{
			con = getConn();
			String sql = "insert into tb_member( "+
						 "id, pwd, name, tel, addr, birth, job, gender, email, intro) "+
						 "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			ps =con.prepareStatement(sql);
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getPwd());
			ps.setString(3,dto.getName());
			ps.setString(4,dto.getTel());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getBirth());
			ps.setString(7, dto.getJob());
			ps.setString(8, dto.getGender());
			ps.setString(9,dto.getEmail());
			ps.setString(10, dto.getIntro());
			int r = ps.executeUpdate();
			if(r>0) {System.out.println("ȸ�����Կ� �����ϼ̽��ϴ�");ok = true;}		
			else{
				System.out.println("����");
				}
		
		}
			catch(Exception e){
			e.printStackTrace();
			
		}
		return ok;
	}
	
	
	
}



































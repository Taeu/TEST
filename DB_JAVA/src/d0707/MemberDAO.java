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
	
	// 데이터베이스에 연결
	public Connection getConn() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER); //1.드라이버를 로딩한다.
			con = DriverManager.getConnection(URL, USER, PASS);	//2.주소, id, 비밀번호를 가지고 연결한다.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//모든 회원리스트를 검색한다.
	public Vector getMemberList() {
		Vector data = new Vector(); //모든 회원들의 정보를 담기 위해서
		
		Connection			con = null;	//데이터베이스와 연결하기 위해서
		PreparedStatement 	ps  = null;	//연결된 데이터베이스에 질의를 하기 위해서
		ResultSet			rs  = null;	//질의에 대한 결과값을 담기 위해서
		
		try {
			con = getConn();	//데이터베이스에 연결
			//질의 내용을 작성한다.
			//회원테이블의 모든 자료를 가져오는데 이름의 내림차순으로 정렬해서 가져온다.
			String sql = "select * from tb_member order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 	//작성한 질의를 실행시킨다.
			
			while(rs.next()) {	//데이터가 있을 때까지 무한반복한다.(1건씩 가져온다)
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
				
				Vector row = new Vector(); //검색한 1건에 대한 데이터를 담기 위해서
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
	
	//id에 해당하는 회원의 정보를 검색한다.
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
			if(r>0) {System.out.println("회원가입에 성공하셨습니다");ok = true;}		
			else{
				System.out.println("실패");
				}
		
		}
			catch(Exception e){
			e.printStackTrace();
			
		}
		return ok;
	}
	
	
	
}



































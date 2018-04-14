package d0706;
// 데이터 베이스 입력 수정 삭제
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel; // 화면에 테이블 형식으로 그려주는 메서드들 쓰려고 

public class MemberDAO {
	/*
	 * Oracle에 접속할 때는 
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@163.239.16.101:1521:ORCL"; // 다른 주소로 접속하려면 Ip 주소 써줘야함
	 * 
	 */
	
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//접속해야할 주소는 아래와 같음
	//private static final String URL = "jdbc:mysql://localhost:3306/sogangdb"; //자기 컴퓨터 접속하려면
	private static final String URL = "jdbc:mysql://163.239.16.101:3306/sogangdb"; // 다른 주소로 접속하려면 Ip 주소 써줘야함
	// 접근권한이 있는경우 id pw를 입력해야 들어갈 수 있음
	private static final String USER = "sogang";
	private static final String PASS = "sogang1234";
	

}

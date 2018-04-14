package d0707;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static Connection getConnection()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String user = "sogang"; 
            String pw = "sogang1234";
            String url = "jdbc:mysql://163.239.16.101:3306/sogangdb";
            
            Class.forName("com.mysql.jdbc.Driver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
            String sql = "select * from tb_member";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	System.out.println(rs.getString("id"));
            	System.out.println(rs.getString("pwd"));
            	System.out.println(rs.getString("name"));
            	System.out.println(rs.getString("tel"));
            	System.out.println(rs.getString("addr"));
            	System.out.println(rs.getString("birth"));
            	System.out.println(rs.getString("job"));
            	System.out.println(rs.getString("gender"));
            	System.out.println(rs.getString("email"));
            	System.out.println(rs.getString("intro"));
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }
    public static void main(String[] args) {
    	DBConnection dc = new DBConnection();
    	dc.getConnection();
    }
}
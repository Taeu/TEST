package d0706;
// ������ ���̽� �Է� ���� ����
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel; // ȭ�鿡 ���̺� �������� �׷��ִ� �޼���� ������ 

public class MemberDAO {
	/*
	 * Oracle�� ������ ���� 
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@163.239.16.101:1521:ORCL"; // �ٸ� �ּҷ� �����Ϸ��� Ip �ּ� �������
	 * 
	 */
	
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//�����ؾ��� �ּҴ� �Ʒ��� ����
	//private static final String URL = "jdbc:mysql://localhost:3306/sogangdb"; //�ڱ� ��ǻ�� �����Ϸ���
	private static final String URL = "jdbc:mysql://163.239.16.101:3306/sogangdb"; // �ٸ� �ּҷ� �����Ϸ��� Ip �ּ� �������
	// ���ٱ����� �ִ°�� id pw�� �Է��ؾ� �� �� ����
	private static final String USER = "sogang";
	private static final String PASS = "sogang1234";
	

}

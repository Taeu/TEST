package d0629;

import java.text.SimpleDateFormat;
import java.util.Date; // 여기에 소속돼 있는 것들을 사용할 것이다.


public class importTest {
	public static void main(String[] args){
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		System.out.println(date.format(today));
		System.out.println(time.format(today));
		System.out.println(today);
		
	}
}

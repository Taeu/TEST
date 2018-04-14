package d0703;
import java.io.*;
import java.util.*;

public class ExceptionTest4 {
	public static void main(String[] args){
		PrintStream ps = null;
		FileOutputStream fos = null;
		System.out.println(1);
		System.out.println(2);
		try{ // javaproject(나의 경우 DB)폴더 아래에 파일을 하나 만듦.
			fos = new FileOutputStream("error.log",true); //error.log파일에 출력할 준비를 한다.(내용을 저장)
			ps = new PrintStream(fos); // 에러의 출력을 화면이 아닌, 파일(error.log)에 기록한다.
			System.setErr(ps);
			
			System.out.println(3);
			System.out.println(0/0); // error를 발생시킴
			System.out.println(4);
		}catch(Exception ae){ // 예외발생시 파일에 찍음. System.err.println();
			System.err.println("---------------");
			System.err.println("예외발생시간:"+new Date());//n new Date()는 현재 시간 
			ae.printStackTrace(System.err);
			System.err.println("예외메시지 : " + ae.getMessage());
			System.err.println("---------------");
		}
		System.out.println(6);
	}
}

package d0703;
import java.io.*;
import java.util.*;

public class ExceptionTest4 {
	public static void main(String[] args){
		PrintStream ps = null;
		FileOutputStream fos = null;
		System.out.println(1);
		System.out.println(2);
		try{ // javaproject(���� ��� DB)���� �Ʒ��� ������ �ϳ� ����.
			fos = new FileOutputStream("error.log",true); //error.log���Ͽ� ����� �غ� �Ѵ�.(������ ����)
			ps = new PrintStream(fos); // ������ ����� ȭ���� �ƴ�, ����(error.log)�� ����Ѵ�.
			System.setErr(ps);
			
			System.out.println(3);
			System.out.println(0/0); // error�� �߻���Ŵ
			System.out.println(4);
		}catch(Exception ae){ // ���ܹ߻��� ���Ͽ� ����. System.err.println();
			System.err.println("---------------");
			System.err.println("���ܹ߻��ð�:"+new Date());//n new Date()�� ���� �ð� 
			ae.printStackTrace(System.err);
			System.err.println("���ܸ޽��� : " + ae.getMessage());
			System.err.println("---------------");
		}
		System.out.println(6);
	}
}

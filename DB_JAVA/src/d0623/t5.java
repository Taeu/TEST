package d0623;
import java.lang.Math;
import java.util.Scanner;
 /* 
 *  0.0 <= Math.random() < 1.0
 *  Math.random() �Լ��� �ҷ����� 0~1���� ������ �������� �ϳ��� �̾���.
 *  ��ǻ�Ͱ� ���� ���ڸ� �������.
 *  Ʋ���� ������ ū�� �����ֱ�
 *  ���ڸ��ߴ� ����
 */

public class t5 {
	public static void main(String[] args){
		int answer =(int)(Math.random()*100+1);
		int input =0;
		int count=0;
		Scanner scanner =new Scanner(System.in);
		
		do{
			count ++;
			System.out.println("1�� 100������ ���� �Է��Ͻʽÿ� : ");
			input = scanner.nextInt();
			if(answer>input){
				System.out.println("�� ū �� �Է��ض�");
			}
			else if(answer<input){
				System.out.println("�� ���� �� �Է��ض�");		
			}
			else {
				System.out.println("����");
				System.out.println(count+"�� �ɸ�");
				break;
			}
		}while(true);
		scanner.close();
		/*
		boolean ans = false;
		//1~100���� ������ ���� �������� 100���ϰ� 1���� ���� ����.
		int x= (int)(Math.random()*100+1);
		Scanner s = new Scanner(System.in);
		int count=0;
		int a; // ����ڰ� �Է��� ��
		while(!ans){
			count++;
			a= s.nextInt();
			if(a==x){
				System.out.println("�¾ҽ��ϴ�!");
				ans=true;
			}else if(a>x){
				System.out.println(a+"�� x���� Ů�ϴ�.");
			}else System.out.println(a+"�� x���� �۽��ϴ�.");
			
	
		}
		System.out.println(count+"�� ���� ������ϴ�~");
		s.close();
		*/
	}
}

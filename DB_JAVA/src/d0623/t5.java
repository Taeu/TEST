package d0623;
import java.lang.Math;
import java.util.Scanner;
 /* 
 *  0.0 <= Math.random() < 1.0
 *  Math.random() 함수를 불러오면 0~1사이 값들중 랜덤으로 하나를 뽑아줌.
 *  컴퓨터가 던진 숫자를 맞춰야함.
 *  틀리면 작은지 큰지 말해주기
 *  숫자맞추는 게임
 */

public class t5 {
	public static void main(String[] args){
		int answer =(int)(Math.random()*100+1);
		int input =0;
		int count=0;
		Scanner scanner =new Scanner(System.in);
		
		do{
			count ++;
			System.out.println("1과 100사이의 값을 입력하십시오 : ");
			input = scanner.nextInt();
			if(answer>input){
				System.out.println("더 큰 수 입력해라");
			}
			else if(answer<input){
				System.out.println("더 작은 수 입력해라");		
			}
			else {
				System.out.println("맞음");
				System.out.println(count+"번 걸림");
				break;
			}
		}while(true);
		scanner.close();
		/*
		boolean ans = false;
		//1~100까지 사이의 수는 랜덤값에 100곱하고 1더한 수랑 같음.
		int x= (int)(Math.random()*100+1);
		Scanner s = new Scanner(System.in);
		int count=0;
		int a; // 사용자가 입력한 수
		while(!ans){
			count++;
			a= s.nextInt();
			if(a==x){
				System.out.println("맞았습니다!");
				ans=true;
			}else if(a>x){
				System.out.println(a+"는 x보다 큽니다.");
			}else System.out.println(a+"는 x보다 작습니다.");
			
	
		}
		System.out.println(count+"번 만에 맞췄습니다~");
		s.close();
		*/
	}
}

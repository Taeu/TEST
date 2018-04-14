package d0623;
/*
 * Q. 피보나치(Fibonnaci) 수열은 두 수를 더해서 다음 수를 만들어 나가는 수열
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
 * 1과 1부터 시작해서, 10번째 숫자가 무엇인지 출력하라.
 * 
 * num1 =1; num2 = 2;
 * num3 = num1+num2;
 *  순서가 매우 중요
 *  
 * 
 */
public class t3 {
	public static void main(String[] args){
		int a=1;
		int b=1;
		int c;
		for(int i = 1; i<=8 ; i++){
			c= a+b;
			a= b;
			b= c;
		}
		System.out.println(b);
	}
}

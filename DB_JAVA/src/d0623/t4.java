package d0623;

public class t4 {
	public static void main(String[] args){
		// 각 자리 숫자 
		// 1+2+3+4+5, 자리를 쪼개서 쪼갠것을 더한 값을 출력하시오
		int num =12345;
		int sum=0;
		while(num>0){
			sum+= num%10; // sum = sum+num%10
			num = num/10; // num /= 10;
		}
		System.out.println(sum);
		
	}
}

package d0623;
/*
 * Q. �Ǻ���ġ(Fibonnaci) ������ �� ���� ���ؼ� ���� ���� ����� ������ ����
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
 * 1�� 1���� �����ؼ�, 10��° ���ڰ� �������� ����϶�.
 * 
 * num1 =1; num2 = 2;
 * num3 = num1+num2;
 *  ������ �ſ� �߿�
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

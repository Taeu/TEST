package d0623;

public class t4 {
	public static void main(String[] args){
		// �� �ڸ� ���� 
		// 1+2+3+4+5, �ڸ��� �ɰ��� �ɰ����� ���� ���� ����Ͻÿ�
		int num =12345;
		int sum=0;
		while(num>0){
			sum+= num%10; // sum = sum+num%10
			num = num/10; // num /= 10;
		}
		System.out.println(sum);
		
	}
}

package d0703;

public class ExceptionTest1 {
	public static void main(String[] args){
		int number= 100;
		int result=0;
		
		for(int i=0; i<10;i++){
			// number�� ������ �� (0~9)�� ������.
			try{
				result = number/(int)(Math.random()*10);
				System.out.println(result);
			// ���α׷� ������ ���� �ƹ� �̻��� ������ ���� �������� 0�� �ǹ����� ������ ����� �ȴ�.
			/*
	Exception in thread "main" java.lang.ArithmeticException: / by zero
	at d0703.ExceptionTest1.main(ExceptionTest1.java:10) (�̷� ���� �޼����� ����)
			 */
			} catch(ArithmeticException e){
				System.out.println("Arithmetic error! ������ 0���� ���� �� �����ϴ�");
			} catch(Exception e){
				
			}
		}
	}
}

package d0703;

public class ExceptionTest1 {
	public static void main(String[] args){
		int number= 100;
		int result=0;
		
		for(int i=0; i<10;i++){
			// number를 임의의 수 (0~9)로 나눈다.
			try{
				result = number/(int)(Math.random()*10);
				System.out.println(result);
			// 프로그램 상으로 보면 아무 이상이 없지만 실제 랜덤값이 0이 되버리면 문제가 생기게 된다.
			/*
	Exception in thread "main" java.lang.ArithmeticException: / by zero
	at d0703.ExceptionTest1.main(ExceptionTest1.java:10) (이런 에러 메세지를 보임)
			 */
			} catch(ArithmeticException e){
				System.out.println("Arithmetic error! 정수를 0으로 나눌 수 없습니다");
			} catch(Exception e){
				
			}
		}
	}
}

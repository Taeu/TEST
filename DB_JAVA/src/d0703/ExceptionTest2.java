package d0703;

public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println(1);
		System.out.println(2);
		try{
			System.out.println(3);
			System.out.println(1/0);
			System.out.println(4);
			
		} catch(Exception e){ // or (ArithmeticException ae)
			System.out.println(e);
			
		}
		System.out.println(6);
	}
}

package d0703;

public class ExceptionTest3 {
	public static void main(String[] args){
		System.out.println(1);
		System.out.println(2);
		try{
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(ArithmeticException ae){
			ae.printStackTrace();
			System.out.println("get Message : "+ae.getMessage());

		}
		System.out.println(6);
	}
}

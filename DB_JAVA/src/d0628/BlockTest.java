package d0628;

public class BlockTest {
	// static 초기화 블럭 , class 초기화 블럭
	static {
		System.out.println("Static{} "); // 가장 먼저 실행된다
		
	}
	
	// instance 초기화 블럭
	{
		System.out.println("Instance {} ");
		
	}
	public BlockTest(){
		System.out.println("Constructor(){}");
	}
	
	public static void main(String[] args){
		System.out.println("start1 from this line");
		BlockTest bt1= new BlockTest();
		System.out.println("start2 from this line");
		BlockTest bt2 = new BlockTest();
		
		System.out.println("\ncheck priorty [ static -> instance -> constructor ]");
		A a = new A();
		A b = new A();
		initTest c = new initTest();
		System.out.printf("cv : %d, iv : %d", c.cv,c.iv);
	}
}

class A{
	A(){System.out.println("construct a(){}");}
	{
		System.out.println("instance a{}");
	}
	static { System.out.println("static A {}");
	}
}
class initTest{
	static int cv =1;
		   int iv =1;
	static { cv=2;}
	 	   { iv=2;}
	initTest(){ iv=3;}
	
}
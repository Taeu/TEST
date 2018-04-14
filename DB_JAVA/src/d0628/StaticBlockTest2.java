package d0628;

public class StaticBlockTest2 {
	static int[] arr = new int[10];
	
	static{
		for(int i=0;i<arr.length;i++){
			// 배열에 1과 10 사이의 임의의 값을 할당한다.
			arr[i] = (int)(Math.random()*10+1);
		}
		
	}
	
	public static void main(String[] args){
		for(int i = 0; i<arr.length; i++){
			System.out.println("arr["+i+"] : "+arr[i]);
			
		}
		
	}
}

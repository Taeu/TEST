package d0628;

public class StaticBlockTest2 {
	static int[] arr = new int[10];
	
	static{
		for(int i=0;i<arr.length;i++){
			// �迭�� 1�� 10 ������ ������ ���� �Ҵ��Ѵ�.
			arr[i] = (int)(Math.random()*10+1);
		}
		
	}
	
	public static void main(String[] args){
		for(int i = 0; i<arr.length; i++){
			System.out.println("arr["+i+"] : "+arr[i]);
			
		}
		
	}
}

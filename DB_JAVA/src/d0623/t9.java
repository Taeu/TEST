package d0623;
import java.util.*;

public class t9 {
	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		for(int i=0;i<10;i++){
			a.add(a.get(i)+a.get(i+1));
		}
		for(int i =0; i<a.size();i++){	
			System.out.print(a.get(i)+" ");
		}
		System.out.println();
		System.out.printf("%d번째 숫자는 %d 입니다.",10,a.get(9));
		
	}
}

package d0623;
import java.util.Scanner;
/*
 * 
 */
public class t1 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		while(true){
			if(sum>100) break;
			i++;
			sum +=i;
		}
		System.out.println(i);
		System.out.println(sum);
		s.close();
	}
}

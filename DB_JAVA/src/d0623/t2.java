package d0623;
/*
 * Loop1 라는 반복문의 이름을 할당해서
 * break Loop1 이라는 것은 Loop1에 해당하는 반복문을 벗어나라는 의미.
 * 
 * 
 */
public class t2 {
	public static void main(String[] args){
		Loop1 : for(int i = 2; i<=9; i++){ 
			for(int j =1; j<=9; j++){
				if(j==5) break Loop1;
				System.out.println(i+"x"+j+"="+i*j);
			}
		}
		
	}
}

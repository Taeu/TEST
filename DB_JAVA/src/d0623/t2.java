package d0623;
/*
 * Loop1 ��� �ݺ����� �̸��� �Ҵ��ؼ�
 * break Loop1 �̶�� ���� Loop1�� �ش��ϴ� �ݺ����� ������ �ǹ�.
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

package d0623;
/*
 * (1) System.arraycopy를 이용해 배열을 복사하기
 * (2) 문자배열과 문자열간의 관계
 */
public class t8 {
	public static void main(String[] args){
		int[] number1 = {1,2,3,4,5};
		int[] newNumber = new int[5];
		System.arraycopy(number1,0,newNumber,0,number1.length);
		for(int i =0; i<newNumber.length; i++)
			System.out.println(newNumber[i]);
		
		char[] abc={'A','B','C','D'};
		char[] number={'0','1','2','3','4','5','6','7','8','9'};
		System.out.println(new String(abc));
		System.out.println(new String(number));
		// abc와 number를 붙여서 하나의 배열(result)를 만든다.
		char[] result= new char[abc.length+number.length];
		//System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(number, 0, result, abc.length, number.length);
		System.out.println(new String(result));
		/*
		 * int[][] score = {{90,80,85},{70,90,92},{88,77,66} };
		 * 3명의 국어 영어 수학 점수가 다음과 같이 주어져있다.
		 *   국어 영어 수학 총점 평균을 구해보자.
		 * a 90  80  85
		 * b
		 * c
		 * 총점 - - - 
		 */
		/* 선생님 코드
		int korTotal=0,engTotal=0,matTotal=0;
		for(int i =0; i<score.length;i++){
		int sum=0;
		korTotal+=score[i][0];
		engTotal+=score[i][1];
		matTotal+=score[i][2];
		System.out.println(" " + (i+1) + " "); // 학생번호
			for(int j=0; j<score[i].length; j++){ // 학생이 개개인이 가지고 있는 점수들
				System.out.print(score[i][j]+ " ");
				sum++score[i][j];
			}
			// 총점만 평균만 구하면 된다.
			System.out.println(sum +"   " + sum/score[i].length);
		}
		System.out.println("총점 : " +korTotal+" "+engTotal+" "+matTotal);
		
		
		
		 */
		int[][] scorea = {{90,80,85},{70,90,92},{88,77,66} };
		System.out.println("      국어    영어    수학    총점    평균");
		int sum=0;
		float average=0;
		int sums[]=new int[3];
		// 학생들의 총점과 평균
		for(int i =0; i<scorea.length;i++){
			for(int j=0; j<3;j++){
				sums[j]+=scorea[i][j];
				sum+=scorea[i][j];
			}
			average=(float)sum/3;
			System.out.printf("%d%5d%5d%5d%5d%6.1f\n",i, scorea[i][0],scorea[i][1],scorea[i][2],sum,average);
			sum=0;
			average=0;
		}
		//과목별 총점과 평균
		sum=sums[0]+sums[1]+sums[2];
		average=(float)sum/3;
		System.out.printf("총점%4d%5d%5d %4d%6.1f\n",sums[0],sums[1],sums[2],sum,average);
		
	}
}

package d0623;
/*
 * 배열을 배울 것. 
 * 배열의 순서는 0번부터 시작한다.
 * for문 초기값도 이제 0번부터 시작하게끔 짤 것이다.
 * 많은 양의 데이터를 정리할 때 유용.
 */
public class t6 {
	public static void main(String[] args){
		//int score1 = 0, score2=1, score3=3;
		// type이 같은 자료인데 이것을 50개만된다고 생각해도 이렇게 적는 것은 비효율적이다.
		// 그래서 배열이라는 도구를 쓴다
		int[] score = new int[5]; 
		// int형[]방을 score라는 이름으로하고. = new(새로운) int[5] 5개의 int 자료를 담는 방을 만들겠다.
		// 배열은 연속적으로 할당한다.
		// int[0] int[1] int[2] int[3] int[4]
		//   -     -      -      -       -  
		// 이렇게 5개의 int 공간이 생겼다고 생각하면 된다.
		// 선언할 때 초기화(값을 할당하는 것)를 안해주면 0으로 초기화가 된다.
		// 타입[] 변수이름; int[] score; String[] name;
		// 타입 변수이름[]; 둘다 허용됨; int score[]; String name[];
		// 초기화 하지 않으면 배열의 기본 값은
		// boolean : false
		// char : '\u0000' // 빈공간
		// byte,short,int : 0
		// long : 0L 
		// double : 0.0 또는 0.0d
		// float : 0.0f
		// 참조형변수 : null
		score[0]=100;
		score[1]=90;		
		score[2]=60;			
		// 선언과 동시에 값을 할당하고 싶으면
		//int[] scoreA = {100,30,50,20,70};//1 방법
		//int[] scoreB = new int[]{100,30,50,20,70}; //2방법
		// 둘 다 동일함.
		/*
		int[] score;
		score = {100,30,50,20,70};
		선언해주고 난 다음에는 이렇게 값을 할당시켜줄 수 없다.그럼 어떻게?
		score = new int[]{100,30,50,20,70};
		*/
		// 배열의 크기를 알고 싶을 때, 배열.length 
		//int n = score.length;
	}	
}

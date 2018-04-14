package d0703;
// gui 예제 1
import javax.swing.*;
// 전체 틀(컨테이너, 프레임)이 있고 필요한 기능(컴포넌트)들을 추가함.

public class MyApp {
	public static void main(String[] args){
		JFrame f = new JFrame(); //기본 틀 생성 완료
		f.setSize(300,500); // size 가로 세로
		f.setVisible(true); // 화면에 보이게 하려면. 
		// 1. 타이틀 
		f.setTitle("첫번째 프레임 타이틀"); 
		
	}
}

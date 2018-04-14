package d0703;

import javax.swing.*;
import java.awt.*;
// ContentPaneEx

public class MyApp3 extends JFrame{
	MyApp3(){ // 생성자
		setTitle("ContentPane"); // 얘는 프렘이에 붙는 것, 상단 바니까
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 우상단의 x버튼을 눌렀을 때 실행 종료.
		
		Container contentPane = getContentPane(); // 컴포넌트를 올리기 위한 것
		contentPane.setBackground(Color.ORANGE);
		//FlowLayout 왼쪽기준으로 정렬, 컴포넌트간의 좌우간격(hGap) 30, 상하간격(vGap) 40; 
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,40)); 
		contentPane.add(new JButton("OK")); // 버튼 생성
		contentPane.add(new JButton("Cancel")); // 다른 버튼 생성
		contentPane.add(new JButton("ignore"));
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args){
		new MyApp3(); // 메인은 클래스를 호출하고, 생서자가 작업하게 된다.
	}
}

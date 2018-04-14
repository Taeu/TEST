package d0703;

import javax.swing.*;
import java.awt.*;
public class MyApp4 extends JFrame{
	MyApp4(){
		setTitle("Border Layout Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		add(new JButton("+"), BorderLayout.NORTH);
		add(new JButton("-"), BorderLayout.SOUTH);
		add(new JButton("x"), BorderLayout.EAST);
		add(new JButton("/"), BorderLayout.WEST);
		add(new JButton("calculator"), BorderLayout.CENTER);
		
		setSize(300,200);
		setVisible(true);
		
	}
	public static void main(String[] args){
		new MyApp4();
	}
}

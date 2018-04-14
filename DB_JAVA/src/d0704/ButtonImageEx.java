package d0704;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
	Container contentPane;
	ButtonImageEx() {
		setTitle("버튼에 아이콘 달기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout()); 

		ImageIcon normalIcon = new 
				ImageIcon("C:/Users/Taeu/Desktop/call.png");
		Image image = normalIcon.getImage();
		Image newing = image.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH );
		normalIcon = new ImageIcon(newing);
		
		ImageIcon rolloverIcon = new 
				ImageIcon("C:/Users/Taeu/Desktop/call2.png");
		image = rolloverIcon.getImage();
		newing = image.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH );
		rolloverIcon = new ImageIcon(newing);
		
		ImageIcon pressedIcon = new 
				ImageIcon("C:/Users/Taeu/Desktop/call3.jpg");
		image = pressedIcon.getImage();
		newing = image.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH );
		pressedIcon = new ImageIcon(newing);
		
		JButton btn = new JButton("call~~\n", normalIcon);
		btn.setRolloverIcon(rolloverIcon);
		btn.setPressedIcon(pressedIcon);
		contentPane.add(btn);

		setSize(250,200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new ButtonImageEx();
	}
} 

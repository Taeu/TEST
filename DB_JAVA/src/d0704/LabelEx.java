package d0704;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LabelEx extends JFrame {
	Container contentPane;
	LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("사랑합니다.");
		// 이미지를 불러올 경로를 지정해 주어야함.
		ImageIcon beauty = new ImageIcon("C:/Users/Taeu/Desktop/2017_5학기/대학생활 우수사례 공모전/대학생활_우수사례_포스터_자료/icon/Heart-icon.png");
		// 사이즈 조정 - beauty
		Image image2 = beauty.getImage();
		Image newing2 = image2.getScaledInstance(300,300, java.awt.Image.SCALE_SMOOTH );
		beauty = new ImageIcon(newing2);
		
		JLabel imageLabel = new JLabel(beauty);
		ImageIcon normalIcon = new ImageIcon("C:/Users/Taeu/Desktop/call.png");
		// 사이즈 조정 - normalIcon
		Image image = normalIcon.getImage();
		Image newing = image.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		normalIcon = new ImageIcon(newing);
		JLabel label = new JLabel("보고싶으면 전화하세요", normalIcon, SwingConstants.CENTER);

		contentPane.add(textLabel);
		contentPane.add(imageLabel);
		contentPane.add(label);

		setSize(350,450);
		setVisible(true);
	}
	public static void main(String [] args) {
		new LabelEx();
	} 
} 
package d0704;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LabelEx extends JFrame {
	Container contentPane;
	LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("����մϴ�.");
		// �̹����� �ҷ��� ��θ� ������ �־����.
		ImageIcon beauty = new ImageIcon("C:/Users/Taeu/Desktop/2017_5�б�/���л�Ȱ ������ ������/���л�Ȱ_������_������_�ڷ�/icon/Heart-icon.png");
		// ������ ���� - beauty
		Image image2 = beauty.getImage();
		Image newing2 = image2.getScaledInstance(300,300, java.awt.Image.SCALE_SMOOTH );
		beauty = new ImageIcon(newing2);
		
		JLabel imageLabel = new JLabel(beauty);
		ImageIcon normalIcon = new ImageIcon("C:/Users/Taeu/Desktop/call.png");
		// ������ ���� - normalIcon
		Image image = normalIcon.getImage();
		Image newing = image.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		normalIcon = new ImageIcon(newing);
		JLabel label = new JLabel("��������� ��ȭ�ϼ���", normalIcon, SwingConstants.CENTER);

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
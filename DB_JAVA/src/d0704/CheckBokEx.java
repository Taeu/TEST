package d0704;
import javax.swing.*;
import java.awt.*;

public class CheckBokEx extends JFrame {
	Container contentPane;
	CheckBokEx() {
		setTitle("체크박스 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		ImageIcon cherryIcon= new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);

		//JCheckBox cherry = new JCheckBox("체리");
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);

		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);

		setSize(250,150);
		setVisible(true);
	}
	public static void main(String [] args) {
		new CheckBokEx();
	}
}

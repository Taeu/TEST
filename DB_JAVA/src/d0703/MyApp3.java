package d0703;

import javax.swing.*;
import java.awt.*;
// ContentPaneEx

public class MyApp3 extends JFrame{
	MyApp3(){ // ������
		setTitle("ContentPane"); // ��� �����̿� �ٴ� ��, ��� �ٴϱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ x��ư�� ������ �� ���� ����.
		
		Container contentPane = getContentPane(); // ������Ʈ�� �ø��� ���� ��
		contentPane.setBackground(Color.ORANGE);
		//FlowLayout ���ʱ������� ����, ������Ʈ���� �¿찣��(hGap) 30, ���ϰ���(vGap) 40; 
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,40)); 
		contentPane.add(new JButton("OK")); // ��ư ����
		contentPane.add(new JButton("Cancel")); // �ٸ� ��ư ����
		contentPane.add(new JButton("ignore"));
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args){
		new MyApp3(); // ������ Ŭ������ ȣ���ϰ�, �����ڰ� �۾��ϰ� �ȴ�.
	}
}

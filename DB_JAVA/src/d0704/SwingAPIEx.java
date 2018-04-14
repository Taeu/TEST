package d0704;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAPIEx extends JFrame{
	Container contentPane;
	JLabel la;
	JButton b1, b2, b3, b4;
	
	SwingAPIEx(){
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//��ư �����
		b1 = new JButton("��ġ�� ũ�� ����");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);
		
		b2 = new JButton("��� ����");
		b2.setOpaque(true);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("����ü",Font.ITALIC,20));
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);
		
		b3= new JButton("�۵����� �ʴ� ��ư");
		// �Ʒ��� �ƹ� ���۵� ���ϰ� �ϴ� ��.
		b3.setEnabled(false);
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);
		
		b4 = new JButton("�����/���̱�");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		setSize(500,500);
		setVisible(true);
		
	}
	class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource(); // ActionEvent�� ������ ������ � ��ư���� �� �� �ִ�.
			if(source == b1){
				System.out.println("��ư�� ��ġ�� ũ��");
				System.out.println("��ġ = ("+b1.getX()+","+b2.getY()+")");
				System.out.println("ũ�� = ("+b1.getWidth()+"x"+b1.getHeight()+")");
			
			JPanel c = (JPanel)b2.getParent();
			System.out.println("����Ʈ�� ��ġ�� ũ��");
			System.out.println("��ġ = ("+c.getX()+","+c.getY()+")");
			System.out.println("ũ��= ("+c.getWidth()+","+c.getHeight()+")");
			}
			else if(source == b2){
				System.out.println("��Ʈ = "+b2.getFont());
				System.out.println("���� = "+b2.getBackground());
				System.out.println("���ڻ� = "+b2.getForeground());
			}
			else{ // b1, b2 ��ư�� �ƴϸ�, (���� b3��ư�� ��Ȱ��ȭ����(b3.setEnable(false)�̹Ƿ�)
				// b4 ��ư�� ����� ���� �ȴ�.
				if(b1.isVisible()){ // b1��ư�� ���϶� ������ �� �����
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				
				else{ // b1��ư�� �� ���� �� ������ �� ���̱�
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);
				}
			}
			
		}
		
	}
	public static void main(String[] args){
		new SwingAPIEx();
	}
}
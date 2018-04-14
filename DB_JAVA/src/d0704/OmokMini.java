package d0704;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// error file
public class OmokMini extends JFrame implements MouseListener{
	JLabel btn1;
	JLabel btn2;
	JLabel btn3; // current button
	JPanel contentPane = new JPanel();
	OmokMini(){
		setTitle("OmokMini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		setLayout(null);
		ImageIcon white = new ImageIcon("C:/Users/Taeu/Desktop/white.png");
		Image image = white.getImage();
		Image newing = image.getScaledInstance(15,15, java.awt.Image.SCALE_SMOOTH );
		white = new ImageIcon(newing);
		ImageIcon black = new ImageIcon("C:/Users/Taeu/Desktop/black.jpg");
		image = black.getImage();
		newing = image.getScaledInstance(15,15, java.awt.Image.SCALE_SMOOTH );
		black = new ImageIcon(newing);
		btn1 = new JLabel(white);
		btn2 = new JLabel(black);
		
		// (draw Line)
		setSize(330,330);
		setVisible(true);
		
	}
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==MouseEvent.BUTTON3){
				btn3 = btn1;
			}
			else {
				btn3 = btn2;
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			
			JLabel btn4 = btn3;
			btn4.setLocation((x/30)*30,(y/30)*30);
			
			contentPane.add(btn4);
			
			// /30 * 30���� ����.			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args){
		// ������ �������
		// Frame�� �������� �׸���.  : �������� �� �� : 9��, �� ���� - 30
		// ���콺 ���ʹ�ư�� ������ ���� ��, ���콺 �����ʹ�ư�� ������ �� 
		// ���� Ŭ���� ���� ���� ����� �������� ���´�.
		new OmokMini();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

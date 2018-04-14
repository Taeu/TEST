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
		
		//버튼 만들기
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);
		
		b2 = new JButton("모양 정보");
		b2.setOpaque(true);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("고딕체",Font.ITALIC,20));
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);
		
		b3= new JButton("작동하지 않는 버튼");
		// 아래는 아무 동작도 안하게 하는 것.
		b3.setEnabled(false);
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);
		
		b4 = new JButton("숨기기/보이기");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		setSize(500,500);
		setVisible(true);
		
	}
	class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource(); // ActionEvent의 정보를 가지고 어떤 버튼인지 알 수 있다.
			if(source == b1){
				System.out.println("버튼의 위치와 크기");
				System.out.println("위치 = ("+b1.getX()+","+b2.getY()+")");
				System.out.println("크기 = ("+b1.getWidth()+"x"+b1.getHeight()+")");
			
			JPanel c = (JPanel)b2.getParent();
			System.out.println("컨텐트의 위치와 크기");
			System.out.println("위치 = ("+c.getX()+","+c.getY()+")");
			System.out.println("크기= ("+c.getWidth()+","+c.getHeight()+")");
			}
			else if(source == b2){
				System.out.println("폰트 = "+b2.getFont());
				System.out.println("배경색 = "+b2.getBackground());
				System.out.println("글자색 = "+b2.getForeground());
			}
			else{ // b1, b2 버튼이 아니면, (현재 b3버튼은 비활성화상태(b3.setEnable(false)이므로)
				// b4 버튼을 누루는 것이 된다.
				if(b1.isVisible()){ // b1버튼이 보일때 나머지 다 숨기기
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				
				else{ // b1버튼이 안 보일 때 나머지 다 보이기
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

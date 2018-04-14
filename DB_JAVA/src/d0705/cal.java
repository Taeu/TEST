package d0705;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cal extends JFrame{
	JTextField t1, t2;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JButton pl,mi,mu,di,eq,c;
	String x,y;
	int Operator;
	Container contentPane;
	cal(){
		Operator = 4; //(+ : 0, - : 1 , x : 2, / : 3)
		contentPane=getContentPane();
		setSize(285,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("calculator");
		
		JPanel p = new JPanel();
		p.setLayout(null);
		
		//display 창을 만든다.
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		p.add(t1);
		p.add(t2);
		t1.setBackground(Color.YELLOW);							//현재 값이 입력되고 있는 창의 배경색을 노란색
		t1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,24)); //폰트종류, 폰트모양, 폰트 사이즈
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("Arial", Font.ITALIC+Font.BOLD,22));
		
		// 숫자 버튼 설정
		b1 = new JButton("1");b2 = new JButton("2");
		b3 = new JButton("3");b4 = new JButton("4");
		b5 = new JButton("5");b6 = new JButton("6");
		b7 = new JButton("7");b8 = new JButton("8");
		b9 = new JButton("9");b0 = new JButton("0");
		b1.setFont(new Font("Arial",Font.BOLD,20));b2.setFont(new Font("Arial",Font.BOLD,20));
		b3.setFont(new Font("Arial",Font.BOLD,20));b4.setFont(new Font("Arial",Font.BOLD,20));
		b5.setFont(new Font("Arial",Font.BOLD,20));b6.setFont(new Font("Arial",Font.BOLD,20));
		b7.setFont(new Font("Arial",Font.BOLD,20));b8.setFont(new Font("Arial",Font.BOLD,20));
		b9.setFont(new Font("Arial",Font.BOLD,20));b0.setFont(new Font("Arial",Font.BOLD,20));
		p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);
		p.add(b6);p.add(b7);p.add(b8);p.add(b9);p.add(b0);
		b1.addActionListener(new Number());b2.addActionListener(new Number());
		b3.addActionListener(new Number());b4.addActionListener(new Number());
		b5.addActionListener(new Number());b6.addActionListener(new Number());
		b7.addActionListener(new Number());b8.addActionListener(new Number());
		b9.addActionListener(new Number());b0.addActionListener(new Number());
		
		// 연산버튼 설정
		pl = new JButton("+");
		pl.setFont(new Font("Arial",Font.BOLD,18));
		p.add(pl);
		pl.addActionListener(new Number());
		
		mi = new JButton("-");
		mi.setFont(new Font("Arial",Font.BOLD,18));
		p.add(mi);
		mi.addActionListener(new Number());
		
		mu = new JButton("x");
		mu.setFont(new Font("Arial",Font.BOLD,18));
		p.add(mu);
		mu.addActionListener(new Number());
		
		di = new JButton("/");
		di.setFont(new Font("Arial",Font.BOLD,18));
		p.add(di);
		di.addActionListener(new Number());
		
		eq = new JButton("=");
		eq.setFont(new Font("Arial",Font.BOLD,18));
		p.add(eq);
		eq.addActionListener(new Number());
		
		c = new JButton("C");
		c.setFont(new Font("Arial",Font.BOLD,18));
		p.add(c);
		c.addActionListener(new Number());
	
		////////////// 생성한 버튼들을 적절한 위치에 배치한다.
		t1.setBounds(10,10,245,40); // 제일 처음 위치 (x0,y0,x1,y1) x0,y0 시작 좌표, x1 : width, y1 : heigth
		t2.setBounds(10,55,245,40);
		
		// 상하간격(50), 좌우간격 (50)
		b7.setBounds(10, 105,45,45);
		b4.setBounds(10, 155,45,45);
		b1.setBounds(10, 205,45,45);
		b8.setBounds(60, 105,45,45);
		b5.setBounds(60, 155,45,45);
		b2.setBounds(60, 205,45,45);
		b9.setBounds(110, 105,45,45);
		b6.setBounds(110, 155,45,45);
		b3.setBounds(110, 205,45,45);
		b0.setBounds(10, 255,45,45);
		c.setBounds(60, 255,95,45);
		pl.setBounds(160,105 ,45,45);
		mi.setBounds(160,155 ,45,45);
		mu.setBounds(160,205 ,45,45);
		di.setBounds(160,255,45,45);
		eq.setBounds(210,105, 45,195);
		eq.setBackground(new Color(141,141,141));
		c.setBackground(new Color(192,192,192));
		
		// 판넬을 프레임에 붙이고, 프레임의 위와 보여주기 속성을 설정
		add(p);
		setLocation(400,500);
		setResizable(false);
		setVisible(true);
	}
	private class Number implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// 숫자키와 c가 눌러졌을 때
			if(e.getSource() == b1){
				t1.setText(t1.getText()+"1");	
			}else if(e.getSource() == b2){
				t1.setText(t1.getText()+"2");	
			}else if(e.getSource() == b3){
				t1.setText(t1.getText()+"3");	
			}else if(e.getSource() == b4){
				t1.setText(t1.getText()+"4");	
			}else if(e.getSource() == b5){
				t1.setText(t1.getText()+"5");	
			}else if(e.getSource() == b6){
				t1.setText(t1.getText()+"6");	
			}else if(e.getSource() == b7){
				t1.setText(t1.getText()+"7");	
			}else if(e.getSource() == b8){
				t1.setText(t1.getText()+"8");	
			}else if(e.getSource() == b9){
				t1.setText(t1.getText()+"9");	
			}else if(e.getSource() == b0){
				t1.setText(t1.getText()+"0");	
			}else if(e.getSource() == c){
				t1.setText("");	
				t2.setText("");
			}
			// 연산 버튼이 눌러졌을 경우
			// Operator = 4; //(+ : 0, - : 1 , x : 2, / : 3)
			else if(e.getSource() == pl){
					if(Operator == 4 ){
						x= t1.getText();
						
						Operator = 0;
					}else{
						process(); // 연산을 수행
						x= ""+valX; // valX ?
						Operator = 0;
					
					}
					t2.setText("" + x +"+");
					t1.setText("");
			}else if(e.getSource() == mi){
				if(Operator == 4 ){
					x= t1.getText();
					t1.setText("");
					Operator = 1;
				}else{
					process(); // 연산을 수행
					x= ""+valX; // valX 
					Operator = 1;
				
				}
				t2.setText("" + x +"-");
				t1.setText("");
			}else if(e.getSource() == mu){
				if(Operator == 4 ){
					x= t1.getText();
					t1.setText("");
					Operator = 2;
				}else{
					process(); // 연산을 수행
					x= ""+valX; // valX ?
					Operator = 2;
				
				}
				t2.setText("" + x +"x");
				t1.setText("");
			}else if(e.getSource() == di){
				if(Operator == 4 ){
					x= t1.getText();
					t1.setText("");
					Operator = 3;
				}else{
					process(); // 연산을 수행
					x= ""+valX; // valX ?
					Operator = 3;
				
				}
				t2.setText("" + x +"/");
				t1.setText("");
			}else if(e.getSource() == eq){
				process();
				t2.setText(""+valX);
				t1.setText(""+valY);
				t1.setText("");
			}  // End-ActionListener;
		}

	}
	int valX;
	int valY;
	void process(){
		y= t1.getText();
		valX = Integer.parseInt(x); //화면에 입력된 값은 문자이므로 계산하기 위해 숫자로 바꿈
		valY = Integer.parseInt(y);
		switch(Operator){
		case 0:
			valX +=valY; break;
		case 1:
			valX -=valY; break;
		case 2:
			valX *=valY; break;
		case 3:
			valX /=valY; break;
		}
		Operator = 4;
	}
	public static void main(String[] args){
		new cal();
	}
}

package d0705;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
class Id extends JFrame implements ActionListener{
	static JTextField tf = new JTextField(8); // 아이디를 입력하는 부분
	JButton btn = new JButton("확인"); 		  // 
	WriteThread wt;
	ClientFrame cf;
	public Id(){} // 기본 생성자
	public Id(WriteThread wt, ClientFrame cf){
		super("아이디");
		this.wt = wt;
		this.cf = cf;
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		btn.addActionListener(this);
		
		setBounds(300,300,250,100);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		wt.sendMsg();
		cf.isFirst = false;
		cf.setVisible(true);
		this.dispose();
	}
	static public String getId(){
		return tf.getText();
	}
}

public class ClientFrame extends JFrame implements ActionListener{
	JTextArea txtA = new JTextArea(); // 대화내용을 보여주는 화면 
	JTextField txtF = new JTextField(15); // 메시지를 전송하기 위해 입려하는 필드 
	JButton btnTransfer = new JButton("전송"); //메시지 전송버튼
	JButton btnExit = new JButton("닫기"); //창닫기 버튼
	boolean isFirst = true;
	JPanel p1 = new JPanel();
	Socket socket;
	WriteThread wt; 
	//생성자
	
	public ClientFrame(Socket socket){
		super("이야기 나누기");
		this.socket = socket;
		wt = new WriteThread(this);
		new Id(wt,this);
		
		txtA.setFont(new Font("굴림",Font.ITALIC+Font.BOLD,24));
		txtA.setBackground(Color.YELLOW);
		add("Center",txtA);
		
		p1.add(txtF);
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South",p1);
		
		btnTransfer.addActionListener(this );
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300,300,350,400);
		setVisible(false);
		
		}
	
	//메서드
	public void actionPerformed(ActionEvent e){
		String id = Id.getId(); // 대화 내용에 아이디를 같이 보내기 위해서
		if(e.getSource()== btnTransfer){ // 전송 버튼을 눌렀을 경ㅇ
			//메세지 내용을 입력하지 않고 전송버튼을 눌렀을 경우
			if(txtF.getText().equals("")) return ; //전송할 내용이 없으면
			//전송할 내용이 있다면
			//서버에서 나한테 전송한 내용을 안보내주니까 textArea에 전송내용을 출력한다.
			txtA.append("["+id+"]"+txtF.getText()+"\n");
			wt.sendMsg();
			txtF.setText(""); // 메시지를 전송했으므로 ""로 초기화
		}
		else{ 	// 닫힘 버튼을 눌렀을 경우
			this.dispose();
		}
	}
	
}

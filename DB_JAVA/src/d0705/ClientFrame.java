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
	static JTextField tf = new JTextField(8); // ���̵� �Է��ϴ� �κ�
	JButton btn = new JButton("Ȯ��"); 		  // 
	WriteThread wt;
	ClientFrame cf;
	public Id(){} // �⺻ ������
	public Id(WriteThread wt, ClientFrame cf){
		super("���̵�");
		this.wt = wt;
		this.cf = cf;
		setLayout(new FlowLayout());
		add(new JLabel("���̵�"));
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
	JTextArea txtA = new JTextArea(); // ��ȭ������ �����ִ� ȭ�� 
	JTextField txtF = new JTextField(15); // �޽����� �����ϱ� ���� �Է��ϴ� �ʵ� 
	JButton btnTransfer = new JButton("����"); //�޽��� ���۹�ư
	JButton btnExit = new JButton("�ݱ�"); //â�ݱ� ��ư
	boolean isFirst = true;
	JPanel p1 = new JPanel();
	Socket socket;
	WriteThread wt; 
	//������
	
	public ClientFrame(Socket socket){
		super("�̾߱� ������");
		this.socket = socket;
		wt = new WriteThread(this);
		new Id(wt,this);
		
		txtA.setFont(new Font("����",Font.ITALIC+Font.BOLD,24));
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
	
	//�޼���
	public void actionPerformed(ActionEvent e){
		String id = Id.getId(); // ��ȭ ���뿡 ���̵� ���� ������ ���ؼ�
		if(e.getSource()== btnTransfer){ // ���� ��ư�� ������ �椷
			//�޼��� ������ �Է����� �ʰ� ���۹�ư�� ������ ���
			if(txtF.getText().equals("")) return ; //������ ������ ������
			//������ ������ �ִٸ�
			//�������� ������ ������ ������ �Ⱥ����ִϱ� textArea�� ���۳����� ����Ѵ�.
			txtA.append("["+id+"]"+txtF.getText()+"\n");
			wt.sendMsg();
			txtF.setText(""); // �޽����� ���������Ƿ� ""�� �ʱ�ȭ
		}
		else{ 	// ���� ��ư�� ������ ���
			this.dispose();
		}
	}
	
}

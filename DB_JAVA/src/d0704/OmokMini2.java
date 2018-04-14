package d0704;
import java.awt.*;
import java.awt.event.*;
//������ �������
// Frame�� �������� �׸���.  : �������� �� �� : 9��, �� ���� - 30
// ���콺 ���ʹ�ư�� ������ ���� ��, ���콺 �����ʹ�ư�� ������ �� 
// ���� Ŭ���� ���� ���� ����� �������� ���´�.
/*
 * 1. �ٵ����� �������� �׷����Ѵ�. (���� ������ , ���� ����)
 * 2. �ٵϵ� ( �׷��� ��ġ, ���� ũ�� ���� ���ݺ��� 80%)
 */
public class OmokMini2 extends Frame implements MouseListener{
	final int LINE_NUM = 9; 		// ������ �� �� 
	final int LINE_WIDTH = 50; 		// ������ �� ���� 
	final int BOARD_SIZE = (LINE_NUM-1)*LINE_WIDTH;		//�������� ũ��
	final int STONE_SIZE = (int)(LINE_WIDTH*0.8); 		//���� ũ��
	final int X0; //�������� �׷����� ���� ��ġ : y
	final int Y0; //�������� �׷����� ���� ��ġ : x
	final int FRAME_WIDTH; //FRAME�� �� : ���α���
	final int FRAME_HEIGHT; //FRAME�� ���� : ���α���

	Image img = null;
	Graphics gImg = null; // �׸��� �׷����� ����
	//������
	public OmokMini2(String n){
		super(n);
		// EventHandler�� ����Ѵ�.
		addMouseListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		setVisible(true);//frame �� ȭ�鿡 ���̰� �Ѵ�.
		Insets insets = getInsets(); // ȭ�鿡 ���̱� ������ Insets�� ���� ���� �� ��� ������ ������ 
		// ȭ�鿡 ���� �������� ������ ������ �� ����.
		// �����ǿ� �׷��� ��ġ ��ǥ X0, Y0�� �����Ѵ�.
		X0=insets.left + LINE_WIDTH; // �����ǿ� ���� ���� �� �ణ ����� �׷��ֱ� ���� + LINE_WIDTH;
		Y0=insets.top + LINE_WIDTH; 
		// �������� ũ�⸦ �����Ѵ�.
		FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH *2+insets.left+insets.right; // �� �ǹ̴� ���� �ð���
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH *2 + insets.top + insets.bottom;
		
		// Frame�� ȭ���� ��ġ (200,200)�� ������ ũ�⸦ �����ش�.
		setBounds(200,200,FRAME_WIDTH,FRAME_HEIGHT);// �簢��ó�� �׸� �� �ִ�
		
		img = createImage(FRAME_WIDTH,FRAME_HEIGHT);
		gImg = img.getGraphics();
		setResizable(false); //Frame�� ũ�⸦ �������� ���ϵ��� �Ѵ�.
		drawBoard(gImg); 	 //������ �׸�
	}
	public void drawBoard(Graphics g){
		for(int i=0; i<LINE_NUM; i++){
			g.drawLine(X0, Y0+i*LINE_WIDTH, X0+BOARD_SIZE, Y0+i*LINE_WIDTH); // ���ηα׸�
		}
		for(int i=0; i<LINE_NUM; i++){
			g.drawLine(X0+i*LINE_WIDTH, Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE); // ���ηα׸�
		}
	}
	public void paint(Graphics g){
		if(img == null) return;
		g.drawImage(img,0,0,this);
	}
	public void mousePressed(MouseEvent e){
		//���콺�� Ŭ���Ͽ��� ��쿡 �ʿ��� ������ ������ �����Ѵ�.
		int x = e.getX(); //���콺�� Ŭ���� ��ġ������ ���Ѵ�.
		int y = e.getY();
		// x �Ǵ� y�� ���� �������� �ٱ��� ��� ���̸� �޼��带 �����Ѵ�. == ���� ���� ���ϰ� �Ѵ�.
		if(x<X0-LINE_WIDTH/2||x>X0+BOARD_SIZE+LINE_WIDTH/2||y<Y0-LINE_WIDTH/2||y>Y0+BOARD_SIZE+LINE_WIDTH/2) return;
		
		// ���� �δµ� x,y���� ���� ����� �������� ������ �����ؼ� �����Ѵ�.
		
		float k = (float)(x-X0)/50;
		x = Math.round(k)*50+X0;
		float l = (float)(y-Y0)/50;
		y = Math.round(l)*50+Y0;
		// x�� y�� ������ ���� ũ��(STONE_SIZE)�� ���� Ŭ���� ���� ���� �� �� �ִ�.
		x-=STONE_SIZE/2;
		y-=STONE_SIZE/2;
		/*
		 * x = (x-X0+LINE_WIDTH/2)/LINE_WIDTH *LINE_WIDTH + X0;
		 * y = (y-Y0+LINE_WIDTH/2)/LINE_WIDTH *LINE_WIDTH + Y0;
		 * x-=STONE_SIZE/2;
		 * y-=STONE_SIZE/2;
		 */
		// ���콺�� ���ʹ�ư�� ������ x,y��ǥ�� ���� ���� �׸���.
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
			gImg.setColor(Color.BLACK);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
			gImg.setColor(Color.WHITE);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
			//���� ���� ���� ������ �׵θ��� �׷��ش�.
			gImg.setColor(Color.BLACK);
			gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		repaint();
		// �غ�� �̹������� �����ֱ� ���ؼ��� repaint()�� ȣ���Ѵ�.
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	public static void main(String[] args){
		new OmokMini2("mini");
	}
}

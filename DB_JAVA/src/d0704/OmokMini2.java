package d0704;
import java.awt.*;
import java.awt.event.*;
//간단한 오목게임
// Frame에 오목판을 그린다.  : 오목판의 줄 수 : 9개, 줄 간격 - 30
// 마우스 왼쪽버튼을 누르면 검은 돌, 마우스 오른쪽버튼을 누르면 흰돌 
// 돌은 클릭한 곳의 가장 가까운 교차점에 놓는다.
/*
 * 1. 바둑판의 프래임을 그려야한다. (줄의 개수와 , 줄의 간격)
 * 2. 바둑돌 ( 그려질 위치, 돌의 크기 줄의 간격보다 80%)
 */
public class OmokMini2 extends Frame implements MouseListener{
	final int LINE_NUM = 9; 		// 오목판 줄 수 
	final int LINE_WIDTH = 50; 		// 오목판 줄 간격 
	final int BOARD_SIZE = (LINE_NUM-1)*LINE_WIDTH;		//오목판의 크기
	final int STONE_SIZE = (int)(LINE_WIDTH*0.8); 		//돌의 크기
	final int X0; //오목판이 그려지는 시작 위치 : y
	final int Y0; //오목판이 그려지는 시작 위치 : x
	final int FRAME_WIDTH; //FRAME의 폭 : 가로길이
	final int FRAME_HEIGHT; //FRAME의 높이 : 세로길이

	Image img = null;
	Graphics gImg = null; // 그림을 그려야할 도구
	//생성자
	public OmokMini2(String n){
		super(n);
		// EventHandler를 등록한다.
		addMouseListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		setVisible(true);//frame 을 화면에 보이게 한다.
		Insets insets = getInsets(); // 화면에 보이기 전에는 Insets의 값을 얻을 수 없어서 보여준 다음에 
		// 화면에 대한 프레임의 정보를 가져올 수 있음.
		// 오목판에 그려질 위치 좌표 X0, Y0를 설정한다.
		X0=insets.left + LINE_WIDTH; // 오목판에 줄을 그을 때 약간 띄워서 그려주기 위해 + LINE_WIDTH;
		Y0=insets.top + LINE_WIDTH; 
		// 프레임의 크기를 설정한다.
		FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH *2+insets.left+insets.right; // 이 의미는 다음 시간에
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH *2 + insets.top + insets.bottom;
		
		// Frame을 화면의 위치 (200,200)에 설정한 크기를 보여준다.
		setBounds(200,200,FRAME_WIDTH,FRAME_HEIGHT);// 사각형처럼 그릴 수 있는
		
		img = createImage(FRAME_WIDTH,FRAME_HEIGHT);
		gImg = img.getGraphics();
		setResizable(false); //Frame의 크기를 변경하지 못하도록 한다.
		drawBoard(gImg); 	 //라인을 그림
	}
	public void drawBoard(Graphics g){
		for(int i=0; i<LINE_NUM; i++){
			g.drawLine(X0, Y0+i*LINE_WIDTH, X0+BOARD_SIZE, Y0+i*LINE_WIDTH); // 가로로그림
		}
		for(int i=0; i<LINE_NUM; i++){
			g.drawLine(X0+i*LINE_WIDTH, Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE); // 세로로그림
		}
	}
	public void paint(Graphics g){
		if(img == null) return;
		g.drawImage(img,0,0,this);
	}
	public void mousePressed(MouseEvent e){
		//마우스를 클릭하였을 경우에 필요한 정보와 행위를 설정한다.
		int x = e.getX(); //마우스로 클릭한 위치정보를 구한다.
		int y = e.getY();
		// x 또는 y의 값이 오목판의 바깥을 벗어난 곳이면 메서드를 종료한다. == 돌울 두지 못하게 한다.
		if(x<X0-LINE_WIDTH/2||x>X0+BOARD_SIZE+LINE_WIDTH/2||y<Y0-LINE_WIDTH/2||y>Y0+BOARD_SIZE+LINE_WIDTH/2) return;
		
		// 돌울 두는데 x,y값을 가장 가까운 교차점의 값으로 변경해서 생성한다.
		
		float k = (float)(x-X0)/50;
		x = Math.round(k)*50+X0;
		float l = (float)(y-Y0)/50;
		y = Math.round(l)*50+Y0;
		// x와 y의 값에서 돌의 크기(STONE_SIZE)를 뺴야 클릭한 곳에 돌을 둘 수 있다.
		x-=STONE_SIZE/2;
		y-=STONE_SIZE/2;
		/*
		 * x = (x-X0+LINE_WIDTH/2)/LINE_WIDTH *LINE_WIDTH + X0;
		 * y = (y-Y0+LINE_WIDTH/2)/LINE_WIDTH *LINE_WIDTH + Y0;
		 * x-=STONE_SIZE/2;
		 * y-=STONE_SIZE/2;
		 */
		// 마우스의 왼쪽버튼을 누르면 x,y좌표에 검은 돌을 그린다.
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
			gImg.setColor(Color.BLACK);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
			gImg.setColor(Color.WHITE);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
			//흰돌일 경우는 돌의 검은색 테두리를 그려준다.
			gImg.setColor(Color.BLACK);
			gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		repaint();
		// 준비된 이미지들을 보여주기 위해서는 repaint()를 호출한다.
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	public static void main(String[] args){
		new OmokMini2("mini");
	}
}

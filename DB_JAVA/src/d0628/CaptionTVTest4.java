package d0628;
/*
 * 보통 패키지 이름 만들 때는
 * www.abc.com 
 * package 이름은 com.abc.util~ disp~로 만든다.
 * -칠판
 * tv는 가로, 세로, 높이, 화면 size, power, volume 부분
 * 여기에다 추가기능, 영화를 보면 caption을 추가하는 기능을 +
 * + tv에 usb연결할 수 있는 기능도 추가.
 */
class Tv{
	boolean power; // 전원 상태(on/off)
	int channel;   // 방송 선택
	
	void power(){power= !power;}
	void channelUp(){++channel;}
	void channelDown(){--channel;}
}
class CaptionTv extends Tv{ 
	boolean caption; // 캡션기능 추가
	void displayCaption(String text){
		if(caption){
			System.out.println(text);
		}
	}
}
public class CaptionTVTest4 {
	public static void main(String[] args){
		CaptionTv ctv = new CaptionTv();
		ctv.channel=10;		//부모클래스로부터 상속받은 멤버
		ctv.channelUp();	//부모클래스로부터 상속받은 메소드
		System.out.println(ctv.channel);
		ctv.displayCaption("안녕하세요");
		ctv.caption=true;
		ctv.displayCaption("안녕하세요");
	}
}	

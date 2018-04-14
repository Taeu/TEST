package d0628;
class Tv2{
	boolean power; //전원의 상태
	int channel;	//채널의 상태
	
	void power() { power = !power;} // 파워 버튼이 눌리면 값을 반대로 한다.
	void channelUP(){++channel;}	// 채널을 올린다.
	void channelDown(){--channel;} 	// 채널을 내린다.
	
}
class VCR{
	boolean power; //전원의 상태
	int counter = 0; // VCR이 진행된 상태
	void power(){power = !power;}
	void play(){}
	void stop(){}
	void rew(){} // 테잎을 거꾸로
	void ff(){} // 앞으로 빨리 감기
}
class TVCR extends Tv2{  //Tv2 기능을 상속받아서 사용한다.
	VCR vcr = new VCR(); //VCR 은 객체를 생성해서 포함시킨다.
	int counter =vcr.counter;
	void play()	{vcr.play();}
	void stop()	{vcr.stop();}
	void rew()	{vcr.rew();}
	void ff()	{vcr.ff();}
	
}
public class TVCR7 {  
	public static void main(String[] args){
			
	}
			
}

package d0628;
class Tv2{
	boolean power; //������ ����
	int channel;	//ä���� ����
	
	void power() { power = !power;} // �Ŀ� ��ư�� ������ ���� �ݴ�� �Ѵ�.
	void channelUP(){++channel;}	// ä���� �ø���.
	void channelDown(){--channel;} 	// ä���� ������.
	
}
class VCR{
	boolean power; //������ ����
	int counter = 0; // VCR�� ����� ����
	void power(){power = !power;}
	void play(){}
	void stop(){}
	void rew(){} // ������ �Ųٷ�
	void ff(){} // ������ ���� ����
}
class TVCR extends Tv2{  //Tv2 ����� ��ӹ޾Ƽ� ����Ѵ�.
	VCR vcr = new VCR(); //VCR �� ��ü�� �����ؼ� ���Խ�Ų��.
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

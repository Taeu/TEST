package d0628;
/*
 * ���� ��Ű�� �̸� ���� ����
 * www.abc.com 
 * package �̸��� com.abc.util~ disp~�� �����.
 * -ĥ��
 * tv�� ����, ����, ����, ȭ�� size, power, volume �κ�
 * ���⿡�� �߰����, ��ȭ�� ���� caption�� �߰��ϴ� ����� +
 * + tv�� usb������ �� �ִ� ��ɵ� �߰�.
 */
class Tv{
	boolean power; // ���� ����(on/off)
	int channel;   // ��� ����
	
	void power(){power= !power;}
	void channelUp(){++channel;}
	void channelDown(){--channel;}
}
class CaptionTv extends Tv{ 
	boolean caption; // ĸ�Ǳ�� �߰�
	void displayCaption(String text){
		if(caption){
			System.out.println(text);
		}
	}
}
public class CaptionTVTest4 {
	public static void main(String[] args){
		CaptionTv ctv = new CaptionTv();
		ctv.channel=10;		//�θ�Ŭ�����κ��� ��ӹ��� ���
		ctv.channelUp();	//�θ�Ŭ�����κ��� ��ӹ��� �޼ҵ�
		System.out.println(ctv.channel);
		ctv.displayCaption("�ȳ��ϼ���");
		ctv.caption=true;
		ctv.displayCaption("�ȳ��ϼ���");
	}
}	

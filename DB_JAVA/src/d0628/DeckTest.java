package d0628;

public class DeckTest {
	public static void main(String[] args){
		Deck d = new Deck(); // Deck �����ڿ� ���� ī�� �� ���� ���������.
		Card c = d.pick(0);  // ī�带 ���� ���� ���� ���� �ִ� ī�带 �̴´�.
		System.out.println(c);
		d.shuffle();		 // ī�带 ���´�.
		c =d.pick(0);		 // �ٽ� �ϳ��� �̴´�.
		System.out.println(c);
	}
}



class Card{
	static final int KIND_MAX = 4; 	//ī�� ������ ����
	static final int NUM_MAX = 13; 	//ī�� ���̴� ���� : 1~10, J,Q,K
	static final int SPADE = 1; 	// �����̵�
	static final int DIAMOND = 2; 	// ���̾Ƹ��
	static final int HEART = 3; 	// ��Ʈ
	static final int CLOVER = 4; 	// Ŭ�ι�
	
	int kind;						//ī���� ����
	int number;						//ī���� ����
	
	Card(){ 						//�⺻ ������
		this(SPADE,1);				//���� Ŭ������ �ִ� �ٸ� �����ڸ� ȣ���Ѵ�.
	}
	Card(int kind, int number){		//�Ű������� �ִ� ������
		this.kind= kind;
		this.number = number;
	}
	// ī���� ����(kind)�� ī���� ����(number)�� �������� �˾Ƴ���
	public String toString(){
		String kind = "";
		String number = "";
		
		switch(this.kind){
		case 1 : kind = "SPADE"; break;
		case 2 : kind = "DIAMOND"; break;
		case 3 : kind = "HEART"; break;
		case 4 : kind = "CLOVER"; break;
		default : 
		}
		switch(this.number){
		case 11 : number = "J";break;
		case 12 : number = "Q";break;
		case 13 : number = "K";break;
		default : number = this.number+""; //1~10������ ���� �״�� �Ѱ��ش�.
		}
		return "ī���� ���� : "+kind + ", ī���� ����:"+number;
	}
}
class Deck {
	final int CARD_NUM = 52; // ī�� �ѹ��� ����
	Card c[] = new Card[CARD_NUM];
	Deck() { //������ : Deck�� ī�带 �ʱ�ȭ�Ѵ�.
		int i = 0; //ī�� 52���� �ǹ��Ѵ�.
		for(int k = Card.KIND_MAX; k>0;k--){ //ī�带 �������� ����� ���ؼ� (4�� �ݺ��Ѵ�)
			for(int n = 1; n<=Card.NUM_MAX; n++){ //ī���� ������ ���� ������ 13���̹Ƿ� 
				c[i++] = new Card(k,n);
			}
		}
		
	}
	// Deck.method();
	Card pick(int index){ //������ ��ġ(index)�� �ִ� ī�带 ���� �̴´�. ex) c[42];
		if(0<=index && index < CARD_NUM){
			return c[index];
		}
		else {
			return pick();
		}
	}
	Card pick(){ // Deck���� �������� ī�� �ϳ��� �����Ѵ�.
		int index = (int)(Math.random()*CARD_NUM);
		return pick(index);
	}
	void shuffle(){ //ī�带 ���´�.
		for(int n=0; n<1000; n++){
			int i = (int)(Math.random()*CARD_NUM);
			Card temp = c[0]; // ù��° �濡 �ִ� ���ڸ� �ӽú����� �����Ѵ�.
			c[0] =c[i];		  // ã�� i��°���� ���ڸ� ù��° �濡 �ִ´�.
			c[i] =temp;		  // �ٽ� ����� ������ ��(���� c[0]�� �ִ� ī��)�� i��° ������ �ִ´�.
		}
	}
}

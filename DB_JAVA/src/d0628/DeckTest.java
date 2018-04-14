package d0628;

public class DeckTest {
	public static void main(String[] args){
		Deck d = new Deck(); // Deck 생성자에 의해 카드 한 벌이 만들어진다.
		Card c = d.pick(0);  // 카드를 섞기 전에 제일 위에 있는 카드를 뽑는다.
		System.out.println(c);
		d.shuffle();		 // 카드를 섞는다.
		c =d.pick(0);		 // 다시 하나를 뽑는다.
		System.out.println(c);
	}
}



class Card{
	static final int KIND_MAX = 4; 	//카드 무늬의 개수
	static final int NUM_MAX = 13; 	//카드 무늬당 개수 : 1~10, J,Q,K
	static final int SPADE = 1; 	// 스페이드
	static final int DIAMOND = 2; 	// 다이아몬드
	static final int HEART = 3; 	// 하트
	static final int CLOVER = 4; 	// 클로버
	
	int kind;						//카드의 종류
	int number;						//카드의 숫자
	
	Card(){ 						//기본 생성자
		this(SPADE,1);				//같은 클래스에 있는 다른 생성자를 호출한다.
	}
	Card(int kind, int number){		//매개변수가 있는 생성자
		this.kind= kind;
		this.number = number;
	}
	// 카드의 종류(kind)와 카드의 숫자(number)가 무엇인지 알아낸다
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
		default : number = this.number+""; //1~10까지의 수는 그대로 넘겨준다.
		}
		return "카드의 종류 : "+kind + ", 카드의 숫자:"+number;
	}
}
class Deck {
	final int CARD_NUM = 52; // 카드 한벌의 개수
	Card c[] = new Card[CARD_NUM];
	Deck() { //생성자 : Deck의 카드를 초기화한다.
		int i = 0; //카드 52장을 의미한다.
		for(int k = Card.KIND_MAX; k>0;k--){ //카드를 종류별로 만들기 위해서 (4번 반복한다)
			for(int n = 1; n<=Card.NUM_MAX; n++){ //카드의 종류에 따른 개수가 13개이므로 
				c[i++] = new Card(k,n);
			}
		}
		
	}
	// Deck.method();
	Card pick(int index){ //지정된 위치(index)에 있는 카드를 한장 뽑는다. ex) c[42];
		if(0<=index && index < CARD_NUM){
			return c[index];
		}
		else {
			return pick();
		}
	}
	Card pick(){ // Deck에서 랜덤으로 카드 하나를 선택한다.
		int index = (int)(Math.random()*CARD_NUM);
		return pick(index);
	}
	void shuffle(){ //카드를 섞는다.
		for(int n=0; n<1000; n++){
			int i = (int)(Math.random()*CARD_NUM);
			Card temp = c[0]; // 첫번째 방에 있는 숫자를 임시변수에 복사한다.
			c[0] =c[i];		  // 찾은 i번째방의 숫자를 첫번째 방에 넣는다.
			c[i] =temp;		  // 다시 저장된 변수의 값(원래 c[0]에 있던 카드)을 i번째 방으로 넣는다.
		}
	}
}

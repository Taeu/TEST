package d0630;

public class PolyArgument2 {
	public static void main(String[] args){
		Buyer1 b = new Buyer1();
		Tv1 tv = new Tv1();
		Computer1 com = new Computer1();
		Audio1 audio = new Audio1();
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		
	}
}

class Product1{
	int price; // 제품의 가격
	int bonusPoint; // 제품을 구매할 때 제공하는 보너스 점수
	
	Product1(int price){
		this.price = price;
		this.bonusPoint = price/10; //제품가격의 10%를 보너스로 부여합니다.
	
	}
}
class Tv1 extends Product1{
	
	Tv1(){
		super(100);
	}
	public String toString(){ //Object 클래스의 toString()을 오버라이딩
		return "Tv";
	}
}

class Computer1 extends Product1{
	
	Computer1(){
		super(200);
	}
	public String toString(){
		return "Computer";
	}
}
class Audio1 extends Product1{
	Audio1(){
		super(70);
	}
	public String toString(){
		return "Audio";
	}
}

class Buyer1 {
	int money = 1000; // 구매자가 가지고 있는 금액
	int bonusPoint = 0; // 보너스점수. 현재는 구매이력이 없기 때문에 0이다.
	Product1[] item = new Product1[10]; // 구입한 제품을 저장하기 위한 배열 
	int i = 0 ; // product배열에 사용하는 카운터
	
	
	void buy(Product1 p){
		if(money<p.price){
			System.out.println("가지고 있는 돈이 모자라서 물건을 살 수가 없습니다.");
			return; // 물건살 돈이 모자라면 퇴장
		}
		// money -=pirce;
		money = money - p.price; //구매한 금액만큼 소유한 금액에서 차감한다. 
		bonusPoint += p.bonusPoint; //구매한 제품에 해당하는 보너스점수를 증가시킨다.
		item[i++] = p; //비어있는 item방에 정보를 입력하고 i는 다음방 번호를 갖게된다. i++는 후 증가이므로.
		
		System.out.println(p+"을/를 구입해주셔서 감사합니다.");
	}
	
	// 구매한 제품에 대한 정보를 보여준다.
	void summary(){
		int sum = 0; // 구매한 제품들의 총구매금액
		String itemList ="";  // 구매한 제품들의 모든 목록
		
		// for문을 이용하여 구매한 제품들의 총구매금액과 목록표를 만든다.
		for(int j =0; j<i; j++){
			System.out.println("제품단가 : "+item[j].price);
			sum += item[j].price; //제품의 가격을 sum에 누적시킨다.
			itemList += item[j]+",";
		}
		System.out.println("지금까지 구매한 물품의 총 금액은 "+sum+"입니다");
		System.out.println("지금까지 구매한 물품의 목록은 "+itemList+"입니다");
	}
	
}


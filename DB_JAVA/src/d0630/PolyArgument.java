package d0630;

public class PolyArgument {
	public static void main(String[] args){
		Buyer b =new Buyer();
		Tv  tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		System.out.println("현재 남은 금액은 " +b.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 " +b.bonusPoint + "점입니다");
	}
}

class Product{
	int price; // 제품의 가격
	int bonusPoint; // 제품을 구매할 때 제공하는 보너스 점수
	
	Product(int price){
		this.price = price;
		this.bonusPoint = price/10; //제품가격의 10%를 보너스로 부여합니다.
	
	}
}
class Tv extends Product{
	
	Tv(){
		super(100);
	}
	public String toString(){ //Object 클래스의 toString()을 오버라이딩
		return "Tv";
	}
}

class Computer extends Product{
	
	Computer(){
		super(200);
	}
	public String toString(){
		return "Computer";
	}
}

class Buyer {
	int money = 1000; // 구매자가 가지고 있는 금액
	int bonusPoint = 0; // 보너스점수. 현재는 구매이력이 없기 때문에 0이다.
	
	void buy(Product p){
		if(money<p.price){
			System.out.println("가지고 있는 돈이 모자라서 물건을 살 수가 없습니다.");
			return; // 물건살 돈이 모자라면 퇴장
		}
		// money -=pirce;
		money = money - p.price; 
		bonusPoint += p.bonusPoint;
		System.out.println(p+"을/를 구입해주셔서 감사합니다.");
	}
	
}
package d0630;
import java.util.Vector;
public class PolyArgument3 {
	public static void main(String[] args){
		Buyer3 b = new Buyer3();
		Tv3 tv = new Tv3();
		Computer3 com = new Computer3();
		Audio3 audio = new Audio3();
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
		
	}
}

class Product3{
	int price; // 제품의 가격
	int bonusPoint; // 제품을 구매할 때 제공하는 보너스 점수
	
	Product3(){}
	Product3(int price){
		this.price = price;
		this.bonusPoint = price/10; //제품가격의 10%를 보너스로 부여합니다.
	
	}
}
class Tv3 extends Product3{
	
	Tv3(){
		super(100);
	}
	public String toString(){ //Object 클래스의 toString()을 오버라이딩
		return "Tv";
	}
}

class Computer3 extends Product3{
	
	Computer3(){
		super(200);
	}
	public String toString(){
		return "Computer";
	}
}
class Audio3 extends Product3{
	Audio3(){
		super(70);
	}
	public String toString(){
		return "Audio";
	}
}

class Buyer3 {
	int money = 1000; 			// 구매자가 가지고 있는 금액
	int bonusPoint = 0; 		// 보너스점수. 현재는 구매이력이 없기 때문에 0이다.
	//Product3[] item = new Product3[10]; // 구입한 제품을 저장하기 위한 배열 
	Vector item = new Vector(); //구입한 제품을 저장하기 위해서 Vector 사용
	//int i = 0 ; 				// product배열에 사용하는 카운터
	
	
	void buy(Product3 p){
		if(money<p.price){
			System.out.println("가지고 있는 돈이 모자라서 물건을 살 수가 없습니다.");
			return; // 물건살 돈이 모자라면 퇴장
		}
		// money -=pirce;
		money = money - p.price; 	//구매한 금액만큼 소유한 금액에서 차감한다. 
		bonusPoint += p.bonusPoint; //구매한 제품에 해당하는 보너스점수를 증가시킨다.
		//item[i++] = p; //비어있는 item방에 정보를 입력하고 i는 다음방 번호를 갖게된다. i++는 후 증가이므로.
		item.add(p); 	 //구매한 제품을 Vector에 저장한다. 
		System.out.println(p+"을/를 구입해주셔서 감사합니다.");
	}
	// 구매한 제품을 환불한다.
	// 구매한 제품에 대한 정보를 보여준다.
	void refund(Product3 p){
		if(item.remove(p)){ // p 제품을 Vector에서 제거한다.
			money+=p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하였습니다.");
		}else{
			System.out.println(p+"라는 제품이 없습니다.");
		}
	}
	
	void summary(){
		int sum = 0; 			// 구매한 제품들의 총구매금액
		String itemList ="";  	// 구매한 제품들의 모든 목록
		
		// for문을 이용하여 구매한 제품들의 총구매금액과 목록표를 만든다.
		/*for(int j =0; j<i; j++){
			System.out.println("제품단가 : "+item[j].price);
			sum += item[j].price; //제품의 가격을 sum에 누적시킨다.
			itemList += item[j]+",";
		}
		*/
		for(int j = 0 ; j<item.size();j++){ //구매한 물품의 개수만큼반 반복을 한다.
			Product3 p = (Product3)item.get(j); // 반드시 형변환을 해줘야함.
			sum += p.price;
			itemList += (j==item.size()-1)? p : p+", "; // or ( j==0)? p: ", "+p;
			
		}
		System.out.println("지금까지 구매한 물품의 총 금액은 "+sum+"입니다");
		System.out.println("지금까지 구매한 물품의 목록은 "+itemList+"입니다");
	}
	
}


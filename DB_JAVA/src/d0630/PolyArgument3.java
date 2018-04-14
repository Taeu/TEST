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
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ�� ������ �� �����ϴ� ���ʽ� ����
	
	Product3(){}
	Product3(int price){
		this.price = price;
		this.bonusPoint = price/10; //��ǰ������ 10%�� ���ʽ��� �ο��մϴ�.
	
	}
}
class Tv3 extends Product3{
	
	Tv3(){
		super(100);
	}
	public String toString(){ //Object Ŭ������ toString()�� �������̵�
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
	int money = 1000; 			// �����ڰ� ������ �ִ� �ݾ�
	int bonusPoint = 0; 		// ���ʽ�����. ����� �����̷��� ���� ������ 0�̴�.
	//Product3[] item = new Product3[10]; // ������ ��ǰ�� �����ϱ� ���� �迭 
	Vector item = new Vector(); //������ ��ǰ�� �����ϱ� ���ؼ� Vector ���
	//int i = 0 ; 				// product�迭�� ����ϴ� ī����
	
	
	void buy(Product3 p){
		if(money<p.price){
			System.out.println("������ �ִ� ���� ���ڶ� ������ �� ���� �����ϴ�.");
			return; // ���ǻ� ���� ���ڶ�� ����
		}
		// money -=pirce;
		money = money - p.price; 	//������ �ݾ׸�ŭ ������ �ݾ׿��� �����Ѵ�. 
		bonusPoint += p.bonusPoint; //������ ��ǰ�� �ش��ϴ� ���ʽ������� ������Ų��.
		//item[i++] = p; //����ִ� item�濡 ������ �Է��ϰ� i�� ������ ��ȣ�� ���Եȴ�. i++�� �� �����̹Ƿ�.
		item.add(p); 	 //������ ��ǰ�� Vector�� �����Ѵ�. 
		System.out.println(p+"��/�� �������ּż� �����մϴ�.");
	}
	// ������ ��ǰ�� ȯ���Ѵ�.
	// ������ ��ǰ�� ���� ������ �����ش�.
	void refund(Product3 p){
		if(item.remove(p)){ // p ��ǰ�� Vector���� �����Ѵ�.
			money+=p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "��/�� ��ǰ�Ͽ����ϴ�.");
		}else{
			System.out.println(p+"��� ��ǰ�� �����ϴ�.");
		}
	}
	
	void summary(){
		int sum = 0; 			// ������ ��ǰ���� �ѱ��űݾ�
		String itemList ="";  	// ������ ��ǰ���� ��� ���
		
		// for���� �̿��Ͽ� ������ ��ǰ���� �ѱ��űݾװ� ���ǥ�� �����.
		/*for(int j =0; j<i; j++){
			System.out.println("��ǰ�ܰ� : "+item[j].price);
			sum += item[j].price; //��ǰ�� ������ sum�� ������Ų��.
			itemList += item[j]+",";
		}
		*/
		for(int j = 0 ; j<item.size();j++){ //������ ��ǰ�� ������ŭ�� �ݺ��� �Ѵ�.
			Product3 p = (Product3)item.get(j); // �ݵ�� ����ȯ�� �������.
			sum += p.price;
			itemList += (j==item.size()-1)? p : p+", "; // or ( j==0)? p: ", "+p;
			
		}
		System.out.println("���ݱ��� ������ ��ǰ�� �� �ݾ��� "+sum+"�Դϴ�");
		System.out.println("���ݱ��� ������ ��ǰ�� ����� "+itemList+"�Դϴ�");
	}
	
}


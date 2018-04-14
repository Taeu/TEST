package d0630;

public class PolyArgument {
	public static void main(String[] args){
		Buyer b =new Buyer();
		Tv  tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		System.out.println("���� ���� �ݾ��� " +b.money + "�����Դϴ�.");
		System.out.println("���� ���ʽ� ������ " +b.bonusPoint + "���Դϴ�");
	}
}

class Product{
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ�� ������ �� �����ϴ� ���ʽ� ����
	
	Product(int price){
		this.price = price;
		this.bonusPoint = price/10; //��ǰ������ 10%�� ���ʽ��� �ο��մϴ�.
	
	}
}
class Tv extends Product{
	
	Tv(){
		super(100);
	}
	public String toString(){ //Object Ŭ������ toString()�� �������̵�
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
	int money = 1000; // �����ڰ� ������ �ִ� �ݾ�
	int bonusPoint = 0; // ���ʽ�����. ����� �����̷��� ���� ������ 0�̴�.
	
	void buy(Product p){
		if(money<p.price){
			System.out.println("������ �ִ� ���� ���ڶ� ������ �� ���� �����ϴ�.");
			return; // ���ǻ� ���� ���ڶ�� ����
		}
		// money -=pirce;
		money = money - p.price; 
		bonusPoint += p.bonusPoint;
		System.out.println(p+"��/�� �������ּż� �����մϴ�.");
	}
	
}
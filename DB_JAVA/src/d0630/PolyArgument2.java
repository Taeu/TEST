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
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ�� ������ �� �����ϴ� ���ʽ� ����
	
	Product1(int price){
		this.price = price;
		this.bonusPoint = price/10; //��ǰ������ 10%�� ���ʽ��� �ο��մϴ�.
	
	}
}
class Tv1 extends Product1{
	
	Tv1(){
		super(100);
	}
	public String toString(){ //Object Ŭ������ toString()�� �������̵�
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
	int money = 1000; // �����ڰ� ������ �ִ� �ݾ�
	int bonusPoint = 0; // ���ʽ�����. ����� �����̷��� ���� ������ 0�̴�.
	Product1[] item = new Product1[10]; // ������ ��ǰ�� �����ϱ� ���� �迭 
	int i = 0 ; // product�迭�� ����ϴ� ī����
	
	
	void buy(Product1 p){
		if(money<p.price){
			System.out.println("������ �ִ� ���� ���ڶ� ������ �� ���� �����ϴ�.");
			return; // ���ǻ� ���� ���ڶ�� ����
		}
		// money -=pirce;
		money = money - p.price; //������ �ݾ׸�ŭ ������ �ݾ׿��� �����Ѵ�. 
		bonusPoint += p.bonusPoint; //������ ��ǰ�� �ش��ϴ� ���ʽ������� ������Ų��.
		item[i++] = p; //����ִ� item�濡 ������ �Է��ϰ� i�� ������ ��ȣ�� ���Եȴ�. i++�� �� �����̹Ƿ�.
		
		System.out.println(p+"��/�� �������ּż� �����մϴ�.");
	}
	
	// ������ ��ǰ�� ���� ������ �����ش�.
	void summary(){
		int sum = 0; // ������ ��ǰ���� �ѱ��űݾ�
		String itemList ="";  // ������ ��ǰ���� ��� ���
		
		// for���� �̿��Ͽ� ������ ��ǰ���� �ѱ��űݾװ� ���ǥ�� �����.
		for(int j =0; j<i; j++){
			System.out.println("��ǰ�ܰ� : "+item[j].price);
			sum += item[j].price; //��ǰ�� ������ sum�� ������Ų��.
			itemList += item[j]+",";
		}
		System.out.println("���ݱ��� ������ ��ǰ�� �� �ݾ��� "+sum+"�Դϴ�");
		System.out.println("���ݱ��� ������ ��ǰ�� ����� "+itemList+"�Դϴ�");
	}
	
}


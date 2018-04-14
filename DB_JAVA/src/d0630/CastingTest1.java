package d0630;

public class CastingTest1 {
	public static void main(String[] args){
		Car car = null;
		FireCar fe1 = new FireCar();
		fe1.drive();
		fe1.water();
		car = fe1;
		car.drive();
		//car.water() <- error!
		// Car Ÿ���� ���������� FireCar�� Car�� ��ӹ޾� Ȯ���� ����� ����� ��Ұ� ����.
		FireCar fe2 = null;
		fe2 = (FireCar)car;
		fe2.drive();
		fe2.water();
		
	
	}
}

class Car
{
	String color;
	int door; 
	
	void drive(){ System.out.println("Drive �ڵ����� �����մϴ�.");} // �����ϴ� ���
	void stop(){ System.out.println("Stop ������ �����մϴ�.");}		// ���ߴ� ���
}

class FireCar extends Car // ���� ��ӹ޾Ƽ� �ҹ����� �����Ѵ�.
{
	// ���Ѹ��� ����� �߰��Ѵ�.
	void water(){ System.out.println("���� �Ѹ��ϴ�.");}
}

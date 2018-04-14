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
		// Car 타입의 참조변수는 FireCar가 Car를 상속받아 확장한 기능을 사용할 요소가 없다.
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
	
	void drive(){ System.out.println("Drive 자동차를 운행합니다.");} // 운전하는 기능
	void stop(){ System.out.println("Stop 운행을 정지합니다.");}		// 멈추는 기능
}

class FireCar extends Car // 차를 상속받아서 소방차를 설계한다.
{
	// 물뿌리는 기능을 추가한다.
	void water(){ System.out.println("물을 뿌립니다.");}
}

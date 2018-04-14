package d0703;

public class RepairableTest {
	public static void main(String[] args){
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
	}
}


interface Repairable{}

class Unit{  // ���ӿ��� ���� ��ü���� ������ �ִ� �⺻������ �����Ѵ�.
	int hitPoint;
	final int MAX_HP;
	Unit(int hp){
		MAX_HP=hp;
	}
}

class GroundUnit extends Unit{ 	// Unit�� ��ӹ޾� ���� Unit�� ���õ� ������ �����.
	GroundUnit(int hp){
		super(hp);
	}
}

class AirUnit extends Unit{		// Unit�� ��ӹ޾� ���� Unit�� ���õ� ������ �����.
	AirUnit(int hp){
		super(hp);
	}
}
class Tank extends GroundUnit implements Repairable{
	Tank(){
		super(150);
		hitPoint=MAX_HP;
	}
	public String toString(){
		return "Tank";
	}
}
class Dropship extends AirUnit implements Repairable{
	Dropship(){
		super(125);
		hitPoint= MAX_HP;
	}
	public String toString(){
		return "Dropship";
	}
}

class Marine extends GroundUnit{
	Marine(){
		super(50);
		hitPoint=MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(70);
		hitPoint=MAX_HP;
	}
	void repair(Repairable r){
		if( r instanceof Unit){
			Unit u = (Unit) r;
			while(u.hitPoint!=u.MAX_HP){
				u.hitPoint++;
			}
			System.out.println(u.toString()+"�� ������ �������ϴ�.");
		}
	}
}
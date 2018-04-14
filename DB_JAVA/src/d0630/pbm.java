package d0630;
import java.util.Scanner;

class pi{
	String name;
	String num;
	String birth;
	pi(){}
	pi(String name, String num){
		this.name = name;
		this.num = num;
	}
	pi(String name, String num, String birth){
		this(name,num);
		this.birth = birth;
	}
	void showpi(){
		System.out.println("name : "+name+"\nnum : "+num+"birth "+num);
	}
}
class menu{
	static Scanner k = new Scanner(System.in);
	static int show(){
		System.out.println("���Ͻô� �۾��� �����Ͻʽÿ�");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		return menu.choice();
	}
	static int choice(){
		System.out.print("�Է� : ");
		int c = k.nextInt();
		k.nextLine();
		return c;
	}
}
class pp{ // phonebook program
	final int MAX = 100;
	pi[] storage = new pi[MAX];
	int Cnt=0;
	void input(){
		System.out.print("name : "); String name = menu.k.nextLine();
		System.out.print("num : "); String num = menu.k.nextLine();
		System.out.print("birth : "); String birth = menu.k.nextLine();
		if(Cnt < MAX) storage[Cnt++] = new pi(name,num,birth);
	}
	void search(String name){
		int i = searchIdx(name);
		if(i>=0){
			storage[i].showpi();
			System.out.println("�˻��� �Ϸ�Ǿ����ϴ�.");
		}
		else System.out.println("�����͸� ã�� �� �����ϴ�.");
	}
	void delete(String name){
		int i = searchIdx(name);
		if(i>=0){
			storage[i].showpi();
			System.out.println("�� �����͸� �����մϴ�");
			for(int j = i; j<Cnt-1; j++){
				storage[j] =storage[j+1];
			}
			Cnt--;
		}
		else System.out.println("�����͸� ã�� �� �����ϴ�.");
		
	} 
	int searchIdx(String name){
		for(int i = 0 ; i<Cnt ; i++)
			if(name.compareTo(storage[i].name)==0) return i;
		return -1;
	}
}

public class pbm {
	public static void main(String[] args){
		pp phonebookManager = new pp();
		while(true){
			int n = menu.show();
			switch(n){
			case 1: phonebookManager.input(); break;
			case 2: 
				System.out.print("name you want to search : ");
				String name2 = menu.k.nextLine();
				phonebookManager.search(name2);break;
			case 3: 
				System.out.print("name you want to delete : ");
				String name3 = menu.k.nextLine();
				phonebookManager.delete(name3); break;
			case 4: 
				System.out.println("�ý����� �����մϴ�");
				return;
			default : System.out.println("�ٽ� �Է��Ͻÿ�");
			}
		}
	}
}

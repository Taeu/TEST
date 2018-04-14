package pb;

import java.util.Scanner;

class PhoneInfo{
	// �ν��Ͻ� ����
	String name;
	String phoneNumber;
	String birth;
	// ������
	public PhoneInfo(){}
	public PhoneInfo(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = null;
	}
	public PhoneInfo(String name, String phoneNumber, String birth){
		this(name,phoneNumber);
		this.birth = birth;
	}
	// �޼ҵ�
	public void printpi(){
		System.out.print("name : "+this.name+"\nnumber:"+this.phoneNumber);
		if(this.birth!=null)
			System.out.println("\nbirth : "+this.birth);
	}
}
class PBM { // PhoneBookManger
	// ���� ����
	PhoneInfo[] p = new PhoneInfo[100];
	static int size;
	
	public void inputData(PhoneInfo pi){
		if(size<100) p[PBM.size++]= pi;
	}
	public void searchData(String name){
		for(int i = 0; i<PBM.size; i++){
			if(this.p[i].name.equals(name)) this.p[i].printpi();
		}
	}
	public void deleteData(String name){
		int j =0;
		for(int i = 0; i<PBM.size; i++){
			if(this.p[i].name.equals(name)) {this.p[i].printpi(); 
			System.out.println("�����Ǿ����ϴ�"); j= i;break;
			};
			
		}
		for(; j<PBM.size-1; j++){
			this.p[j].name = this.p[j+1].name;
			this.p[j].phoneNumber = this.p[j+1].phoneNumber;
			this.p[j].birth = this.p[j+1].birth;
		}
		PBM.size--;
	}
	private int search(String name){
		for(int i = 0; i<PBM.size; i++){
			if(this.p[i].name.equals(name)) return i;
		}
		return -1;
	}
	
}
public class pbm1 {
	public static void main(String[] args){
		/*
		PhoneInfo a = new PhoneInfo("hong","010-1111-1111","920117");
		PhoneInfo b = new PhoneInfo("chun","010-1111-1112");
		a.printpi();
		b.printpi();*/
		Scanner k = new Scanner(System.in);
		int siz =0; // p�� ���� ������
		
		int ch = 0;
		while(ch!=2){
		// �޴� showMenu() �κ� - main �ٷ� ���� static method�� �����
		System.out.print("�����ϼ���...\n1.������ �Է�\n2.���α׷�����\n���� :  ");	
		ch = k.nextInt();
		if(ch==2) break;
		k.nextLine();
		// readData() �κ� - main �ٷ� ���� static method�� �����
		System.out.print("�̸� : ");String name = k.nextLine();
		System.out.print("��ȣ : ");String num = k.nextLine();
		System.out.print("������� : ");String birth = k.nextLine();
		PhoneInfo aa = new PhoneInfo(name,num,birth);
		aa.printpi();
		}
		System.out.println("����");
		k.close();

	}
}

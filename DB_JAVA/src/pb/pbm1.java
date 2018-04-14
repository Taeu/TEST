package pb;

import java.util.Scanner;

class PhoneInfo{
	// 인스턴스 변수
	String name;
	String phoneNumber;
	String birth;
	// 생성자
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
	// 메소드
	public void printpi(){
		System.out.print("name : "+this.name+"\nnumber:"+this.phoneNumber);
		if(this.birth!=null)
			System.out.println("\nbirth : "+this.birth);
	}
}
class PBM { // PhoneBookManger
	// 변수 선언
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
			System.out.println("삭제되었습니다"); j= i;break;
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
		int siz =0; // p의 현재 사이즈
		
		int ch = 0;
		while(ch!=2){
		// 메뉴 showMenu() 부분 - main 바로 위에 static method로 만들기
		System.out.print("선택하세요...\n1.데이터 입력\n2.프로그램종료\n선택 :  ");	
		ch = k.nextInt();
		if(ch==2) break;
		k.nextLine();
		// readData() 부분 - main 바로 위에 static method로 만들기
		System.out.print("이름 : ");String name = k.nextLine();
		System.out.print("번호 : ");String num = k.nextLine();
		System.out.print("생년월일 : ");String birth = k.nextLine();
		PhoneInfo aa = new PhoneInfo(name,num,birth);
		aa.printpi();
		}
		System.out.println("종료");
		k.close();

	}
}

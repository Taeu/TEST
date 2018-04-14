package d0628;
class Product{
	static int count = 0;  // 생성된 인스턴스의 수를 저장하기 위한 변수
	int sn ; // sn는 serialNumber. 인스턴스의 고유한 번호를 부여하기 위한 변수
	{
		++count;
		sn=count;
	}
	public Product(){}
}
public class ProductTest3 {
	public static void main(String[] args){
		Product p1 = new Product();
		System.out.println(p1.sn);
		Product p2 = new Product();
		System.out.println(p2.sn);
		Product p3 = new Product();
		System.out.println(p3.sn);
		System.out.println("생산된 제품의 합계:"+Product.count);
		
	}
}

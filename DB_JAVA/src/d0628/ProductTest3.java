package d0628;
class Product{
	static int count = 0;  // ������ �ν��Ͻ��� ���� �����ϱ� ���� ����
	int sn ; // sn�� serialNumber. �ν��Ͻ��� ������ ��ȣ�� �ο��ϱ� ���� ����
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
		System.out.println("����� ��ǰ�� �հ�:"+Product.count);
		
	}
}

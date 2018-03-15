package basic;

public class StringTest {
	public static void main(String[] args) {
		String a = new String("한1");
		String b = new String("한2");		// 가급적 이렇게 쓰래ㅐ애ㅐ애애애애
//		String a = "한";
//		String b = "한";
		
//		if(a.equals(b)){
//			System.out.println("같다");
//		}else
//			System.out.println("다르다");
		
		swap(a,b);
		System.out.println("A="+a);
		System.out.println("B="+b);
		int z =20,y=10;
		swap(z,y);
		System.out.println("Z="+z);
		System.out.println("Y="+y);
	}
	static void swap(String a, String b){
		String temp = a;
		a =b;
		b = temp;
	}
	static void swap(int z, int y){
		int temp = z;
		z =y;
		y = temp;
	}
}

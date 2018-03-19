package util;

public class StringBufferTest {

	public static void main(String[] args) {
		int a= 10;
		add(a);
		System.out.println("결과 =" + a);
		
		String b = new String("안녕");
		add(b);
		System.out.println("결과 =" + b);
		
		StringBuffer b2 = new StringBuffer("행복한");
		add(b2);
		// 참조형이라서 (call by address) 해당 값이 직접 변경된다.
		System.out.println("결과 =" + b2);
		
		StringBuilder b3 = new StringBuilder("아싸");
		
	}
	static StringBuffer add(StringBuffer b2){
		b2.append("자바");
		// 문자열을 붙이는 메서드 append
		return b2;
	}
	 static String add(String b) {
		 String result =  b + "하이";
		return result;
	}
	static int add(int a){
		int result  = a + 5;
		return result;
	}
}

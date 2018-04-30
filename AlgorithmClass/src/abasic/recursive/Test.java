package abasic.recursive;

public class Test {

	public static void main(String[] args) {
		System.out.println(exp(2,10));
	}
	/**
	 * 	x의 m 제곱하는 함수
	 */
	
	static int exp(int x,int m){
		if(m == 0) return 1;
		return x * exp(x,m-1);
	}
}

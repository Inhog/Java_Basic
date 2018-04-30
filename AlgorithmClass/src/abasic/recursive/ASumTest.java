package abasic.recursive;

public class ASumTest {

	public static void main(String[] args) {
		// 1부터 10까지의 합을 구해서 출력
		int sum =0;
		System.out.println(sumFunc(10));
	}
	static int sumFunc(int i){
		if(i==1) return 1;
		return sumFunc(i-1)+i;
	}

}

package abasic.recursive;

public class BMulTest {
	public static void main(String[] args) {
		int i=0;
		System.out.println(mulFunc(5));
		
	}
	
	static int mulFunc(int i){
		if(i==1) return 1;
		return mulFunc(i-1)*i;
	}
}

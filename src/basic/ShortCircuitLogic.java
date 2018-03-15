package basic;

public class ShortCircuitLogic {

	public static void main(String[] args) {

		int a= 3;
		if(a>3&++a>3){			
			// &&를 사용하면 앞 조건식이 만족하지 않으면 뒷 조건식을 실행하지 않는다.(ShortCircuitLogic)
			// &를 사용하면 앞 조건식의 만족 유무를 상관하지않고 모든 조건식을 확인한다.
			System.out.println("satisfied");
		}
		System.out.println("A=" +a);
		
		if(a>1|++a>3){
			System.out.println("satisfied");
		}
		System.out.println("A="+a);
	}

}

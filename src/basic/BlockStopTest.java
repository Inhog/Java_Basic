package basic;

public class BlockStopTest {

	public static void main(String[] args) {

		END:
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				if(j==1) continue END;//continue;		// break;
				System.out.println("<"+i+","+j+">");
			}
			System.out.println("데이타");
		}
	}
	
}

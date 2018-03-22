package basic;

public class Array2Test {

	public static void main(String[] args) {

		char[][] s = new char[26][];
		for(int i=0;i<s.length;i++){
			s[i] = new char[i+1];
		}
		
		for(int i=0;i<s.length;i++){ 
			for(int j=0;j<s[i].length;j++){
				s[i][j] =(char)(((int)'A')+j);
			}
		}
		
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
	}

}

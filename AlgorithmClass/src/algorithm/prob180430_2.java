package algorithm;

import java.util.Scanner;

public class prob180430_2 {
	static boolean flag3 = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		
		while(TC-->0){
			int N = sc.nextInt();
			sc.nextLine();
			for(int i=2;i<=64;i++)
			change(N,i);
			if(flag3 == false){
				System.out.println("0");
			}else{
				System.out.println("1");
		  	}
			flag3 = false;
		}
		
	}
	public static void change(int n,int k){
		String val ="";
		boolean flag = false;
		while(!flag){
			if(n<=k-1){
				val +=n;
				flag = true;
			}else{
				val += String.valueOf(n%k);
				n = n/k;
			}
//			System.out.println(val);
		}
		boolean flag2 = false;
		for(int i=0;i<val.length()/2;i++){
			if(val.charAt(i) != val.charAt(val.length()-1-i)){
				flag2 = true;
			}
		}
		if(flag2 == false){
			flag3 = true;
		}
	}
}


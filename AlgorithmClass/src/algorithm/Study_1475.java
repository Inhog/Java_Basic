package algorithm;

import java.util.Scanner;
// Create by Inho 2018. 5. 1.
public class Study_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] num = new int[10];
		for(int i=0;i<input.length();i++){
			for(int j=0;j<10;j++){
				if(j == input.charAt(i)-48){
					num[j]++;
				}
			}
		}
		int max =0;
		num[9] += num[6];
		for(int i=0;i<10;i++){
			if(max < num[i]){
				if( i == 9 || i == 6){
					if(num[i] %2 ==0){
						max = num[i]/2;
					}else{
						max = num[i]/2+1;
					}
				}else{
					max = num[i];
				}
			}
		}
		System.out.println(max);
	}
}

package algorithm;

import java.util.Scanner;

public class Prob180501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[][] output = new int[N][N];
		int x=0,y=0;
		for(int i=0;i<N;i++){
			if(i%N == 0){
				x = x+1;
				y = 0;
				if(output[y][x] != 0){
					x = x-N;
					output[y][x] = i+1;
				}else{
					output[y][x] =i+1;					
				}
			}else{
				x = x-1;
				y = y-1;
				if(output[y][x] != 0){
				}
			}
		}
	}

}

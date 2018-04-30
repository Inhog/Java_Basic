package algorithm;

import java.util.Scanner;

public class prob180430 {
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		while(N-- >0){
			String number = sc.nextLine();
			String[] value = number.split("");
			kaprekar(value);
		}
	}
	public static void kaprekar(String[] value)
	{
		count++;
		String p = "";
		for(int i=0;i<value.length;i++){
			p += value[i];
		}
		String[] d = selectionSort(value);
		int size = d.length;
		String maxnum = "",minnum="";
		for(int i=0;i<size;i++){
			minnum+= d[i];
			maxnum+= d[size-1-i];
		}
		int sum = Integer.valueOf(maxnum) - Integer.valueOf(minnum);
		String answer = String.valueOf(sum);
		String[] f = answer.split("");
		if(answer.equals("6174")){
			System.out.println(count);
			count=0;
		}else{
		kaprekar(f);
		}
	}
	
	public static String[] selectionSort(String a[]){
		for(int i=0;i<a.length;i++){
			int minidx= i;
			for(int j=i;j<a.length;j++){
				if(Integer.valueOf(a[minidx]) > Integer.valueOf(a[j])){
					minidx = j;
				}
			}
			swap(a,i,minidx);
		}
		return a;
	}
	
	 public static void swap(String a[], int i, int j){
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	 
}

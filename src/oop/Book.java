package oop;

public class Book {
	private static int count=0;
	// static은 객체가 공유하는 변수?
	// static은 메모리에 먼저 생성된다.
	int a =10;
	
	Book(){
		count++;
	}
	
	static public int getCount(){
		return count;
	}
}

package oop;

class Outer{
	static class Inner{
		static void najavara(){
			System.out.println("잡아버림");
		}
	}
}
public class InnerTest {

	public static void main(String[] args) {
		//Outer o = new Outer();
		//Outer.Inner in = o.new Inner();
		//Outer.Inner in = new Outer.Inner();
		
		Outer.Inner.najavara();
	}
}

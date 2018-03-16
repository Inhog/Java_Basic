package oop;

public class Test {

	public static void main(String[] args) {
		data D = method();
		// 4. 반환된 객체 출력
		System.out.println(D.toString());
		D.print();
	}
	
	static data method(){
		String name ="홍길동";
		int age =28;
		double height =160.9;
		data d = new data(name,age,height);
		// 2. 클래스에 데이터 지정
		// 2.(1) 생성자 지정
		// 2.(2) setter지정
		
		return d;
		// 3. 객체를 반환
	}
}
// 1. 클래스 선언
class data{
	private String name;
	private int age;
	private double height;
	data(){}
	data(String name, int age, double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void print(){
		System.out.println("이름 : " + this.name + " 나이 : " + this.age + " 키 : " + this.height);
	}
	@Override
	public String toString(){
		return "이름 : " + this.name + " 나이 : " + this.age + " 키 : " + this.height;
	}
	
	
	
}

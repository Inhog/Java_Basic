package collection;

public class Student {
//	extends Object는 자동으로 붙어있음
	String name;
	int age;
	public Student(){}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return name + " 님 " +age + " 세 입니다.";
	}
	
}

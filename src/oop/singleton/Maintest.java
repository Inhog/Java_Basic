package oop.singleton;

class Book{		
	// 싱글톤 패턴
	static Book b;
	private Book(){
		
		System.out.println("객체생성");
	}
	static public Book getInstance(){		 
		if( b == null)	b = new Book();
		// 맨 처음 Book 클래스는 null을 가리키기 때문에 new Book()으로 생성되고
		// 그 다음 Book 클래스는 이미 static으로 생성되었기 때문에 다시 생성되지는 않는다.
		// 메모리에 하나의 Book클래스만 생성되어있고
		// 그 클래스의 주소를 Book형 객체들이 참조하는 형식이다.
		return b;
	}
}
public class Maintest {
	public static void main(String[] args) {
		Book b1 = Book.getInstance();			
		// 객체를 클래스의 생성자로 생성하기전에 클래스로 getInstance메서드를 접근해서 객체를 생성해야 하기때문에
		// 해당 메서드는 static으로 메모리에 먼저 띄운다.
		// 그리고 메서드 안에있는 변수또한 static으로 메모리에 먼저 띄운다.
		Book b2 = Book.getInstance();
		Book b3 = Book.getInstance();
	}
}

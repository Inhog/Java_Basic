package alist.asingle;
public class MainTest {
	public static void main(String[] args) {

		SList<String> s = new SList<String>();  // 연결 리스트 객체 s 생성
        s.insertFront("orange"); s.insertFront("apple");		s.insertFront("pear"); 			
		s.print();
		s.insertAfter("cherry",s.head.getNext());	// 사과다음에 체리추가.
		s.print();
		s.insertAfter("mango",s.searchItem("apple"));	// 사과다음에 체리추가.
		s.print();
				
		System.out.println(": s의 길이 = "+s.size()+"\n"); 
		System.out.println("체리가 \t"+s.search("cherry")+"번째에 있다.");
		System.out.println("망고가 \t"+s.search("mango")+"번째에 있다.");
		System.out.println("배가 \t"+s.search("pear")+"번째에 있다.\n");
		
		
		s.deleteFront();
		s.print(); 
		System.out.println(": s의 길이 = "+s.size());System.out.println();

		
		s.deleteAfter(s.head);
		s.print(); 
		System.out.println(": s의 길이 = "+s.size());System.out.println();

		
	}
}
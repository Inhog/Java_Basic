package bstack.list;
import java.util.EmptyStackException;
public class ListStack <E> {	
	private Node<E> top;   // 스택 top 항목을 가진  Node를 가리키기 위해
	private int size;      // 스택의 항목 수	
	public ListStack() {   // 스택 생성자
		top = null;
		size = 0;
	}
	public int     size()    { return size;}      // 스택의 항목의 수를 리턴
	public boolean isEmpty() { return size == 0;} // 스택이 empty이면 true 리턴	
	
	/** 스택 push 연산  */
	public void push(E newItem){  
		// 1. 새 노드를 생성하여 리스트 앞부분에 삽입
		// 2. top이 새 노드 가리킴
		// 3. 스택 항목 수 1 증가
	
		
	}
	
	public E peek() {  // 스택 top 항목만을 리턴
		if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지 
		return top.getItem();
	}
	
	/** 스택 pop연산 */
	public E pop() {   
		if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
		// 1. 스택 top 항목을 topItem에 저장
		// 2. top이 top 바로 아래 항목을 가리킴
		// 3. 스택 항목 수를 1 감소
		
		                    
		return null;
	}	
	
	
	public void print() { // 스택의 항목들을 top부터 차례로 출력
		if (isEmpty()) System.out.print("스택이 비어있음.");      
		else 
			for (Node p = top; p != null; p = p.getNext()) 
				System.out.print(p.getItem()+"\t ");
		System.out.println();
	}
	
}
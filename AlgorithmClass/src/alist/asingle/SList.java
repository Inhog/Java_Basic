package alist.asingle;
import java.util.NoSuchElementException;
public class SList <E extends Comparable<E>> {
	
	protected Node head;  // 연결 리스트의 첫 노드 가리킴
	private   int  size;
	public Node getHead() { return head; }
	public void setHead(Node n) { head= n;}

	public SList(){       // 연결 리스트 생성자
		head = null;
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }

	/** 연결리스트 맨 앞에 새 노드 삽입 */
	public void insertFront(E newItem){  
		head = new Node(newItem,head);
		size++;
	}
	
	/** 노드 p 바로 다음에 새 노드 삽입 */
	public void insertAfter(E newItem, Node p){ 
//		Node n = new Node(newItem,null);
//		n.setNext(p.getNext());
//		p.setNext(n);
		p.setNext(new Node(newItem,p.getNext()));
		size++;
	}
	
	/** 리스트의 첫 노드 삭제 */
	public void deleteFront(){       // 
		if (isEmpty()) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	/** p가 가리키는 노드의 다음 노드를 삭제 */
	public void deleteAfter(Node p){ // 
		if (p == null) throw new NoSuchElementException();
		p.setNext(p.getNext().getNext());
		size--;
	}

	 public int search(E target) {   // target을 탐색  
		 Node p = head;
		 for (int  k = 0; k < size ;k++){
			 if (target == p.getItem()) return k;
			 p = p.getNext(); 
		 }
		 return -1; // 탐색을 실패한 경우 -1 리턴
	 }
	 
	 public Node searchItem(E target){
		 Node p = head;
		 for(int i=0;i<size;i++){
			 if(target == p.getItem()) return p;
			 p = p.getNext();
		 }
		 return null;
	 }
	 
	public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
			for (Node p = head; p != null; p = p.getNext()) 
				System.out.print(p.getItem()+"\t ");
			System.out.println();
		}

}

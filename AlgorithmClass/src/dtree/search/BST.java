package dtree.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BST<Key extends Comparable<Key>, Value>{
	public Node root; 
	public Node getRoot() { return root; }
	public BST(Key newId, Value newName){  			// BST 생성자    
		root = new Node(newId, newName);              
		}
	
	//-------------------------------- 
	// 노드 삽입
	public void put(Key k, Value v) {root = put(root, k, v);}
	public Node put(Node n, Key k, Value v){
		if (n == null)  return new Node(k, v);
		// 1. 노드 n의 키값과 입력된 키값 k와 비교
		// 2. if (k < 노드 n의 id) 왼쪽 서브 트리에 삽입
		// 3. if (k > 노드 n의 id) 오른쪽 서브 트리에 삽입
		// 4. 그렇지 않다면 노드 n의 name 값을 value로 변경
		
	
		return n;
	}
	
	
	//------------------------------------
	// 노드 찾기
	public Value get(Key k) {return get(root, k);}
	public Value get(Node n, Key k) {
		if (n == null)  return null;   // k를 발견 못함
		
		// 1. 노드 n의 키값과 입력된 키값 k와 비교
		// 2. if (k < 노드 n의 id) 왼쪽 서브 트리 탐색
		// 3. if (k > 노드 n의 id) 오른쪽서브 트리 탐색
		// 4. 그렇지 않다면 k를 가진 노드를 리턴 ( k를 가진 노드 발견 )
		
		return null;
	}
	

	// 최소값 찾기 : 왼쪽 서브트리로 null을 만날 때 까지 탐색
	public Key min() { 
		if (root == null) return null;
		return (Key) min(root).getKey();}
	private Node min(Node n) {
		if (n.getLeft() == null)  return n;
		return min(n.getLeft());
	}	
	public void deleteMin() {
		if (root == null) System.out.println("empty 트리");
		root = deleteMin(root);	}
	public Node deleteMin(Node n) {
		if (n.getLeft() == null) return n.getRight(); 	// if (n의 왼쪽 자식==null) n의 오른쪽 자식 리턴
		n.setLeft(deleteMin(n.getLeft())); 					// if (n의 왼쪽 자식≠null), n의 왼쪽 자식으로 재귀 호출
		return n;
	}
		
	public void deleteMax() {
        if (root == null)  System.out.println("empty 트리");
        root = deleteMax(root);}
    private Node deleteMax(Node n) {
        if (n.getRight() == null) return n.getLeft();
        n.setRight(deleteMax(n.getRight()));
        return n;
    }
    
    //*****************************************************************
    // 노드 삭제 
	public void delete(Key k) {root = delete(root, k);} 
	public Node delete(Node n, Key k) {
		if (n==null) return null;  
		// 1. 노드 n의 키값과 입력된 키값 k와 비교
		// 2. if (k < 노드 n의 id) 왼쪽 자식으로 이동하면서 
		// 3. if (k > 노드 n의 id) 오른쪽 자식으로 이동하면서
		// 4. 그렇지 않다면 삭제할 노드를 발견한 것임
		//		- case 0 : 자식이 없는 경우
		//		- case 1 : 자식이 하나 인 경우
		//		- case 2 : 자식이 둘 다 있는 경우	
		
		
		
		
		return n;
	} 
 
    public int height() {return height(root)+1;}
    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }
    
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	public void inorder(Node n){       // 중위 순회
		if (n != null) {
			inorder(n.getLeft());   // n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(n.getKey()+" ");  // 노드 n 방문
			inorder(n.getRight());  // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	public void levelorder(Node root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node t;
		q.add(root);  // 루트 노드 큐에 삽입
		while (!q.isEmpty()) { 
			t = q.remove();   //큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey()+" "); // 제거된 노드 출력(방문)
			if (t.getLeft() != null)      // 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());       // 큐에 왼쪽 자식 삽입
			if (t.getRight() != null)     // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());      // 큐에  오른쪽 자식 삽입
		} 
	}
	public void preorder(Node n) {     // 전위 순회
		if (n != null) {
			System.out.print(n.getKey()+" ");  // 노드 n 방문
			preorder(n.getLeft());  // n의 왼쪽    서브 트리를 순회하기 위해
			preorder(n.getRight()); // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
}


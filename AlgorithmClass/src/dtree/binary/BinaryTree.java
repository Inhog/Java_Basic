package dtree.binary;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>>  {
	private Node root;

	public BinaryTree( ) { root = null; }      // 트리 생성자

	public Node getRoot( )            { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }

	public boolean isEmpty( ) { return root == null; }

	public void preorder(Node n) {     // 전위 순회
		
	}

	public void inorder(Node n){       // 중위 순회
		
	}

	public void postorder(Node n) {     // 후위 순회 
		
	}
	
	public void levelorder(Node root) { // 레벨 순회
		
	}
	
	public int size(Node n)	{  // n를 루트로하는 (서브)트리에 있는 노드 수
		if (n == null)   
			return 0;   // null이면 0 리턴
		else  
			return (1 + size( n.getLeft() ) + size( n.getRight() )); 
	}

	public int height(Node n) {  // n를 루트로하는 (서브)트리의 높이
		if (n == null)   
			return 0;    // null이면 0 리턴
		else  
			return (1 + Math.max(height(n.getLeft()), height(n.getRight()))); 
	}
	
}

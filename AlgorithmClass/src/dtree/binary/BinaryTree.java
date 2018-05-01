package dtree.binary;

import java.util.*;

public class BinaryTree<Key extends Comparable<Key>>  {
	private Node root;

	public BinaryTree( ) { root = null; }      // 트리 생성자

	public Node getRoot( )            { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }

	public boolean isEmpty( ) { return root == null; }

	public void preorder(Node n) {     // 전위 순회
		System.out.print(n.getKey() + "\t");
		if(n.getLeft()!=null)
		preorder(n.getLeft());
		if(n.getRight()!=null)
		preorder(n.getRight());
	}

	public void inorder(Node n){       // 중위 순회
		if(n.getLeft()!=null)
		inorder(n.getLeft());
		System.out.print(n.getKey() + "\t");
		if(n.getRight()!=null)
		inorder(n.getRight());
	}

	public void postorder(Node n) {     // 후위 순회 
		if(n.getLeft()!=null)
		postorder(n.getLeft());
		if(n.getRight()!=null)
		postorder(n.getRight());
		System.out.print(n.getKey() + "\t");
	}
	
	public void levelorder(Node root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>();
		System.out.print(root.getKey() + "\t");
		q.add(root.getLeft());
		q.add(root.getRight());
		while(!q.isEmpty()){
			Node next = q.poll();
			if(next != null){
				System.out.print(next.getKey() + "\t");
				q.add(next.getLeft());
				q.add(next.getRight());				
			}
		}
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

	public static boolean isEqual(Node n, Node nn) {
		if(n == null || nn == null)	return n==nn;
		if(n.getKey().compareTo(nn.getKey()) !=0){
			return false;
		}
		
		return isEqual(n.getLeft(),nn.getLeft()) && isEqual(n.getRight(),nn.getRight());
	}
	
}

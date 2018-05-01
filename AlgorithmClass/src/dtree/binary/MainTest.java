package dtree.binary;

public class MainTest {

	public static void main(String[] args) {

		Node n1 = new Node(100,null,null); 	Node n2 = new Node(200,null,null);
		Node n3 = new Node(300,null,null);	Node n4 = new Node(400,null,null);	
		Node n5 = new Node(500,null,null);	Node n6 = new Node(600,null,null);
		Node n7 = new Node(700,null,null);	Node n8 = new Node(800,null,null);

		n1.setLeft(n2); n1.setRight(n3);  // n1의 왼쪽 자식-> n2, n1의 오른쪽 자식-> n3
		n2.setLeft(n4);	n2.setRight(n5);  // n2의 왼쪽 자식-> n4, n2의 오른쪽 자식-> n5
		n3.setLeft(n6);	n3.setRight(n7);  // n3의 왼쪽 자식-> n6, n3의 오른쪽 자식-> n7
		n4.setLeft(n8); 				  // n4의 왼쪽 자식-> n8
		
		BinaryTree t = new BinaryTree();  // 이진 트리 객체 t 생성 
		t.setRoot(n1); 					  // t의 루트 노드를 n1으로
		
		Node nn1 = new Node("우리한국대학교",null,null); 	Node nn2 = new Node("공과대학",null,null);
		Node nn3 = new Node("사회대학",null,null);	Node nn4 = new Node("컴퓨터공학과",null,null);	
		Node nn5 = new Node("정보통신학과",null,null);	Node nn6 = new Node("경영학과",null,null);
		Node nn7 = new Node("경제학과",null,null);	Node nn8 = new Node("정보통신",null,null);
		Node nn9 = new Node("정보보안",null,null);	Node nn10 = new Node("경제정보",null,null);

		nn1.setLeft(nn2); nn1.setRight(nn3);  // n1의 왼쪽 자식-> n2, n1의 오른쪽 자식-> n3
		nn2.setLeft(nn4);	nn2.setRight(nn5);  // n2의 왼쪽 자식-> n4, n2의 오른쪽 자식-> n5
		nn3.setLeft(nn6);	nn3.setRight(nn7);  // n3의 왼쪽 자식-> n6, n3의 오른쪽 자식-> n7
		nn5.setLeft(nn8); nn5.setRight(nn9);  // n4의 왼쪽 자식-> n8
		nn7.setRight(nn10);
		BinaryTree t1 = new BinaryTree();  // 이진 트리 객체 t 생성 
		t1.setRoot(nn1); 					  // t의 루트 노드를 n1으로
		
		System.out.print("트리 노드 수  = "+ t.size(t.getRoot())+"\n트리 높이      = "+ t.height(t.getRoot()));
		System.out.printf("\n전위 순회:  ");
		t.preorder(t.getRoot());
		System.out.printf("\n중위 순회:  ");
		t.inorder(t.getRoot());
		System.out.printf("\n후위 순회:  ");
		t.postorder(t.getRoot());
		System.out.printf("\n레벨 순회:  ");
		t.levelorder(t.getRoot());
		System.out.println();
		
		System.out.print("트리 노드 수  = "+ t1.size(t1.getRoot())+"\n트리 높이      = "+ t1.height(t1.getRoot()));
		System.out.printf("\n전위 순회:  ");
		t1.preorder(t1.getRoot());
		System.out.printf("\n중위 순회:  ");
		t1.inorder(t1.getRoot());
		System.out.printf("\n후위 순회:  ");
		t1.postorder(t1.getRoot());
		System.out.printf("\n레벨 순회:  ");
		t1.levelorder(t1.getRoot());
		System.out.println();

		System.out.println("동일성 검사 : "+ BinaryTree.isEqual(t.getRoot(), t.getRoot()));

	
	}
}



//-------------------------------------------------------------------------------
// [ 추가 ] 아래와 같이 출력되도록 
// 중위 순회:  컴퓨터공학과 공과대학 정보통신 정보통신학과 정보보안 우리한국대학교 경영학과 사회대학 경제학과 경제정보 
// 후위 순회:  컴퓨터공학과 정보통신 정보보안 정보통신학과 공과대학 경영학과 경제정보 경제학과 사회대학 우리한국대학교 




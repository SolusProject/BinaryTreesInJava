
public class Main {
	
	public static void main (String args[]) {
		Tree rbt = new RedBlackTree();
		
		rbt.add(50);
		rbt.add(70);
		rbt.add(60);
		rbt.add(30);
		rbt.add(3);
		rbt.add(10);
		rbt.add(8);
		rbt.add(17);
		rbt.add(68);
		//rbt.add(79);
		rbt.add(18);
		//rbt.add(90);
		
		
		System.out.println(rbt.find(68).getColor());
		rbt.remove(70);
		System.out.println(rbt.find(68).getColor());
		//System.out.println(x.getValue());
		
//		System.out.println(rbt.getRoot().getColor());
//		System.out.println(rbt.getRoot().getLeft().getColor());
//		System.out.println(rbt.getRoot().getLeft().getLeft().getColor());
//		System.out.println(rbt.getRoot().getLeft().getLeft().getLeft().getColor());
		//System.out.println(rbt.getRoot().getLeft().getColor());
//		System.out.println(rbt.getRoot().getRight().getColor());
		
		
//		rbt.add(5);
//		rbt.add(10);
//		rbt.add(20);
		//rbt.add(2);

	
		//
//		System.out.println(rbt.getRoot().getColor());
//		System.out.println(rbt.getRoot().getRight().getValue());
		
		//System.out.println(rbt.getRoot().getLeft().getColor());
		//System.out.println(rbt.getRoot().getRight().getColor());
		//System.out.println(rbt.getRoot().getLeft().getLeft().getColor());
		
//		avl.add(10);
//		avl.add(5);
//		avl.add(20);
//		avl.add(15);
//		avl.add(25);
//		avl.add(40);
		
		
		//avl.remove(5);
		
		
		Traverse traverse = new Traverse();
		
	
		
//		System.out.println(root.getHeight());
//		System.out.println(node.getHeight());
//		System.out.println(rc.getHeight());
//		
//		
		//System.out.println(rc.getParent().getParent().getValue());
		
		
//		System.out.println(rr.getHeight());
//		bst.add(10);
//		bst.add(13);
//		bst.add(18);
//		bst.add(8);
//		bst.add(88);
//		bst.add(45);
//		
//		System.out.println(bst.getRoot().getRight().getLeft().getValue());
		
		
		//System.out.println(avl.getRoot().getValue());
		
		
		System.out.println(traverse.BFS(rbt));
		System.out.println(traverse.inOrderDFS(rbt));
		System.out.println(traverse.preOrderDFS(rbt));
		System.out.println(traverse.postOrderDFS(rbt));
	}
	
}

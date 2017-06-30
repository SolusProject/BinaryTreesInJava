
public class AVL extends BasicTree implements Tree{
	
	@Override
	public boolean exists(Integer value) {
		if(!super.hasRoot()) return false;
		return super.exists(value, super.root);
	}
	
	@Override
	public Node find(Integer value) {
		if(!super.hasRoot()) return null;
		return super.find(value, super.root);
	}
	
	@Override
	public Node smallest() {
		if(!super.hasRoot()) return null;
		return super.smallest(this.root);
	}
	
	@Override 
	public Node getRoot() {
		return super.root;
	}
	
	@Override
	public void unmark() {
		super.unmark();
	} 
	
	
	@Override
	public Node add(Integer value) {
		if(!super.hasRoot()) { 
			super.setRoot(new Node(value));
			super.root.setHeight(1);
			return super.root;
		} else {
			Node node = super.add(value, super.root);
			Node parent = node.getParent();
			
			// while we have somewhere up to go
			while(parent != null) {		
				// if you don't get your parent first - then after the swap you will get into infinite loop
				Node parent_before_swap = parent.getParent();
				rotationIfNeeded(parent,1);
				parent = parent_before_swap;
			}
			return node;
		}	
	}
	
	
	@Override
	public Node remove(Integer value) {
		if(value == super.root.getValue() && !super.root.hasLeft() && super.root.hasRight()) {
			Node return_ = super.root;
			super.resetRoot();
			return return_;
		}
		return remove(find(value));
	}

	
	private Node remove(Node node) {
		Node parent = node.getParent();
		Integer isLeft = null;
		
		if(parent == null) 
			isLeft = -1;
		else if(parent.hasLeft() && parent.getLeft().equals(node)) 
			isLeft = 1;
		else if(parent.hasRight() && parent.getRight().equals(node))
			isLeft = 0;
		else 
			System.err.println("Something went wrong. Probably it will breaks... kidding, it's already broke");
		
		// scenario 1 is a leaf
		if(!node.hasLeft() && !node.hasRight()) {
			parent.setLeft((isLeft==1)? null : parent.getLeft());
			parent.setRight((isLeft==0)? null : parent.getRight());
		} else if(node.hasLeft() ^ node.hasRight()) {
			// depending on condition - set either left or right child
			Node child = node.hasLeft()? node.getLeft() : node.getRight();
			parent.setLeft((isLeft==1)? child : parent.getLeft());
			parent.setRight((isLeft==0)? child : parent.getRight());
			child.setParent(parent);
		} else if(node.hasLeft() && node.hasRight()) {
			Node swap_node = smallest(node.getRight());
			Integer temp = swap_node.getValue(); // value of the smallest on the right subtree
			swap_node.setValue(node.getValue());
			node.setValue(temp);
			return remove(swap_node);
		}

		rotationIfNeeded(parent, -1);
		return node;
	}

	
	public void rotationIfNeeded(Node parent, Integer ratio) {
		Integer leftHeight = parent.hasLeft()? parent.getLeft().getHeight() : 0;
		Integer rightHeight = parent.hasRight()? parent.getRight().getHeight() : 0;
		Integer greaterHeight = leftHeight <= rightHeight? rightHeight : leftHeight;
		
		// update parent height
		if(parent.getHeight() <= greaterHeight) parent.setHeight(greaterHeight+ratio);
		
		if(Math.abs(leftHeight-rightHeight) >= 2) {
			Node child = leftHeight > rightHeight? parent.getLeft() : parent.getRight();
			Node clc = child.getLeft();
			Node crc = child.getRight();
			
			Integer clcHeight = clc != null? clc.getHeight() : 0;
			Integer crcHeight = crc != null? crc.getHeight() : 0;
			
			if(leftHeight>rightHeight) {
				if(clcHeight > crcHeight) {
					super.rightRotation(parent, child);
					parent.setHeight(parent.getHeight()-2);
				}
				else {
					super.leftRotation(child, child.getRight());
					super.rightRotation(parent, parent.getLeft());
					parent.setHeight(parent.getHeight()-2);
				}
			} else {
				if(clcHeight < crcHeight) {
					super.leftRotation(parent, child);
					parent.setHeight(parent.getHeight()-2);
				} else {
					super.rightRotation(child, child.getLeft());
					super.leftRotation(parent, parent.getRight());
					parent.setHeight(parent.getHeight()-2);
				}
			}
		}
	}
	
	


}

public class BST extends BasicTree implements Tree {
	
	
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
		if(!super.hasRoot()) return super.root = new Node(value);
		else return super.add(value, super.root);
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
	
	public Node remove(Node node) {
		if(node == null) return node;
		
		Node parent = node.getParent();
		
		Integer isLeft = -1;
		
		if(parent != null) {
			if(parent.hasLeft() && parent.getLeft().equals(node)) 
				isLeft = 1;
			else if(parent.hasRight() && parent.getRight().equals(node))
				isLeft = 0;
		}
		
		if(!node.hasLeft() && !node.hasRight()) {
			if(isLeft == -1) {
				node = super.root;
				super.root = null;
			} else if(isLeft == 1)
				parent.setLeft(null);
			else if(isLeft == 0) 
				parent.setRight(null);
		} else if(node.hasLeft() && !node.hasRight()) {
			if(isLeft == -1) {
				node = super.root;
				super.root = node.getLeft();
			} else if(isLeft == 1)
				parent.setLeft(node.getLeft());
			else if(isLeft == 0)
				parent.setRight(node.getLeft());
		} else if(!node.hasLeft() && node.hasRight()) {
			if(isLeft == -1) {
				node = super.root;
				super.root = node.getRight();
			} else if(isLeft == 1)
				parent.setLeft(node.getRight());
			else if(isLeft == 0)
				parent.setRight(node.getRight()); 
		} 
		
		else if(node.hasLeft() && node.hasRight()) {
			// double check it
			Node swap_node = smallest(node.getRight());
			Integer temp = swap_node.getValue();
			swap_node.setValue(node.getValue());
			node.setValue(temp);
			return remove(swap_node);
		}
		return node;
	}

}

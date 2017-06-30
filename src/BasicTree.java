import java.util.Stack;

public class BasicTree {
	protected Node root;
	
	protected Node getRoot() {
		return this.root;
	}
	
	protected void setRoot(Node node) {
		this.root = node;
		node.setParent(null);
	}
	
	protected void resetRoot() {
		this.root = null;
	}
	
	protected boolean hasRoot() {
		return this.root == null? false : true;
	}

	protected void unmark() {
		Stack<Node> stack = new Stack<>();
		if(this.root == null) return;
		stack.push(this.root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			node.setVisited(false);
			
			if(node.hasLeft()) 
				stack.push(node.getLeft());
			if(node.hasRight())
				stack.push(node.getRight());
		}
	}
	
	protected boolean exists(Integer value, Node node) {
		if(value == node.getValue())
			return true;
		else if(value < node.getValue() && node.hasLeft()) 
			return exists(value, node.getLeft());
		else if(value > node.getValue() && node.hasRight())
			return exists(value, node.getRight());
		return false;
	}
	
	
	protected Node find(Integer value, Node node) {
		if(node.getValue() == value) 
			return node;
		else if(value < node.getValue() && node.hasLeft())
			return find(value, node.getLeft());
		else if(value > node.getValue() && node.hasRight())
			return find(value, node.getRight());
		return null;
	}
	
	
	protected Node smallest(Node node) {
		if(!node.hasLeft())
			return node;
		return smallest(node.getRight());
	}
	
	
	protected void rightRotation(Node parent, Node child) {
		if(parent == null || child == null) return;
		swapParent(parent, child);
		parent.setLeft(child.getRight());
		child.setRight(parent);
	}
	
	
	protected void leftRotation(Node parent, Node child) {
		if(parent == null || child == null) return;
		
		swapParent(parent, child);
		parent.setRight(child.getLeft());
		child.setLeft(parent);
		
	}
	
	private void swapParent(Node parent, Node child) {
		Node gParent = parent.getParent();
		
		// change parent
		if(gParent != null) {
			if(gParent.hasRight() && gParent.getRight().equals(parent)) gParent.setRight(child);
			else if(gParent.hasLeft() && gParent.getLeft().equals(parent)) gParent.setLeft(child);
			else 
				System.out.println("Something went terribly wrong");
		} else {
			this.root = child;
			child.setParent(null);
		}
	}
	
	protected Node add(Integer value, Node this_) {
		Node node = null;
		
		if(value < this_.getValue()) {
			if(this_.hasLeft()) 
				node = add(value, this_.getLeft());
			else {	
				node = new Node(value, this_);
				this_.setLeft(node);
			}		
		} else if (value > this_.getValue()) {
			if(this_.hasRight())
				node = add(value, this_.getRight());
			else { 
				node = new Node(value, this_);
				this_.setRight(node);
			}	
		}
		return node;
	}
	
	
}

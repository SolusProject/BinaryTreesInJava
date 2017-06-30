
public class RedBlackTree extends BasicTree implements Tree {

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
		if(super.root == null) {
			// because its a root
			super.root = new Node(value, "black");			
			return super.root;
		} else {
			Node new_node = super.add(value, super.root);
			new_node.setColorRed();
			rebalanceIfNeeded(new_node);
			return new_node;
		}
	}	

	
	@Override
	public Node remove(Integer value) {
		return remove(find(value));
	}
	
	
	private Node remove(Node node) {
		if(node == null) return null;
		
		Node parent = node.getParent();
		
		if(!node.equals(super.root) && parent == null) {
			System.out.println("Node for some reason does not has a parent");
			return null;
		}
		
		
	
		// if no children or 1 child
		if((node.hasRight() ^ node.hasLeft()) || (!node.hasLeft() && !node.hasRight())) {
			Node child = node.hasLeft()? node.getLeft() : node.getRight();
			// if node is red - just remove it
			if(node.isRed()) {
				// just remove it (root cannot be red) 
				if(parent.hasLeft() && parent.getLeft().equals(node))   parent.setLeft(child);
				else if(parent.hasRight() && parent.getRight().equals(node)) parent.setRight(child);
			}
			// if node is black but it has a red child (no grandchild will be red)
			if(node.isBlack() && ((node.hasRight() && node.getRight().isRed()) || (node.hasLeft() && node.getLeft().isRed())))  {
				if(node.equals(super.root)) {
					if(child != null) super.setRoot(child);
					return null;
				} else {
					if(parent.hasLeft() && parent.getLeft().equals(node)) parent.setLeft(child);
					else if(parent.hasRight() && parent.getRight().equals(node)) parent.setRight(child);
					child.setColorBlack();
				}
			}
			
			
			
			
			
			
			
			System.out.println("Node has one or 0 children");
				
			
			
			
			
			
			
	
		} else 
			System.out.println("Node has 2 children");
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		return node;
	} 
	
	
	
	

	public void rebalanceIfNeeded(Node node) {
		Node parent = node.getParent();
		if(parent == null) return; 
		Node gParent = parent.getParent();
		if(gParent == null) return;

		if(node.getParent().isRed()) {
		
			Node uncle = node.getUncle();
			
			if (uncle != null && uncle.getColor().equals(parent.getColor())) {
				
				parent.setColorBlack();
				uncle.setColorBlack();
				
				if(!gParent.equals(super.root)) 
					gParent.setColorRed();
				
				rebalanceIfNeeded(gParent);
				
			} else {
				// single right rotation
				if(gParent.hasLeft() && gParent.getLeft().equals(parent) 
						&& parent.hasLeft() && parent.getLeft().equals(node)) {
					
					super.rightRotation(gParent, parent);
					parent.setColorBlack();
					gParent.setColorRed();
				}
				
				// single left rotation
				else if(gParent.hasRight() && gParent.getRight().equals(parent) && 
						parent.hasRight() && parent.getRight().equals(node)) {
						
					super.leftRotation(gParent, parent);
					parent.setColorBlack();
					gParent.setColorRed();
				}
				
				// left right rotation
				else if(gParent.hasLeft() && gParent.getLeft().equals(parent) &&
						parent.hasRight() && parent.getRight().equals(node)) {
					
					super.leftRotation(parent, node);
					super.rightRotation(gParent, node);
					node.setColorBlack();
					gParent.setColorRed();
				}
				
				// right left rotation 
				else if(gParent.hasRight() && gParent.getRight().equals(parent) 
					&& parent.hasLeft() && parent.getLeft().equals(node) ) {
					
					super.rightRotation(parent, node);
					super.leftRotation(gParent, node);
					node.setColorBlack();
					gParent.setColorRed();
				} 	
			} 
		}
	}

}

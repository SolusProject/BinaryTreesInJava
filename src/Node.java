
public class Node {
	
	private Integer value;
	private Integer height;
	private Node parent;
	private Node left;
	private Node right;
	private boolean visited;
	private String color;
	
	public Node(Integer value) {
		this.value = value;
		this.height = 0;
	}
	
	public Node(Integer value, Node parent) {
		this.value = value;
		this.height = 1;
		this.parent = parent;
	}
	
	public Node(Integer value, String color) {
		this.value = value;
		this.color = color;
	}
	
	
	public Integer getHeight() {
		return this.height;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setLeft(Node node) {
		this.left = node;
		if(node != null) node.setParent(this);	
	}

	public void setRight(Node node) {
		this.right = node;
		if(node != null) node.setParent(this);
	}
		
	public boolean hasLeft() {
		return (this.left == null)? false : true;
	}
	
	public boolean hasRight() {
		return (this.right == null)? false : true;
	}

	public boolean hasParent() {
		return (this.parent == null)? false : true;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	} 
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public void setColorRed() {
		this.color = "red";
	}
	
	public void setColorBlack() {
		this.color = "black";
	}
	
	public String getColor() {
		return this.color;
	}
	
	public boolean isRed() {
		return this.color == "red"? true : false; 
	}
	
	public boolean isBlack() {
		return this.color == "black"? true : false; 
	}
	
	public Node getUncle() {
		Node parent = this.getParent();
		if(parent == null) return null;
		Node grandParent = parent.getParent();
		if(grandParent == null) return null;
		
		if(grandParent.getLeft() != null)
			return grandParent.getLeft().equals(parent)? grandParent.getRight() : grandParent.getLeft();
		else if(grandParent.getRight() != null)  
			return grandParent.getRight().equals(parent)? grandParent.getLeft() : grandParent.getRight();
		return null;
	}
	
	public boolean isLeft(Node node) {
		if(this.hasLeft() && this.getLeft().equals(node)) return true;
		return false;
	}
	
	public boolean isRight(Node node) {
		if(this.hasRight() && this.getRight().equals(node)) return true;
		return false;
	}
	
	
	public Node getSibling() {
		Node parent = this.getParent();
		if(parent == null) return null;
		
		if(parent.hasLeft() && parent.hasRight())
			return parent.isLeft(this)? parent.getRight() : parent.getLeft();
		return null;
	}
	
	
	
}

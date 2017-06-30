import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traverse {
	
	
	public List<Integer> BFS(Tree tree) {
		List<Integer> bfs = new ArrayList<>();
		if(tree.getRoot() == null) return bfs;
		
		Queue<Node> q = new LinkedList<>();
		q.add(tree.getRoot());
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			bfs.add(node.getValue());
			node.setVisited(true);
			
			if(node.hasLeft() && !node.getLeft().isVisited()) 
				q.add(node.getLeft());
			if(node.hasRight() && !node.getRight().isVisited())
				q.add(node.getRight());
		}
		
		tree.unmark();
		return bfs;
	}
	
	// in order - left child first, parent, right
	public List<Integer> inOrderDFS(Tree tree) {
		List<Integer> dfs = new ArrayList<>();
		if(tree.getRoot() == null) return dfs;
		Stack<Node> stack = new Stack<>();	
		stack.push(tree.getRoot());
	
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if(node.isVisited()) continue;
			
			boolean left = node.hasLeft() && !node.getLeft().isVisited();
			boolean right = node.hasRight() && !node.getRight().isVisited();
			
			if(right)
				stack.push(node.getRight());
			if(left) {
				stack.push(node);
				stack.push(node.getLeft());
			}
			if(!left) {
				dfs.add(node.getValue());
				node.setVisited(true);
			}			
		}
		
		tree.unmark();
		return dfs;
	}
	
	// parent then left, then right
	public List<Integer> preOrderDFS(Tree tree) {
		List<Integer> dfs = new ArrayList<>();
		if(tree.getRoot() == null) return dfs;
		Stack<Node> stack = new Stack<>();
		
		stack.push(tree.getRoot());
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if(node.isVisited()) continue;
			
			dfs.add(node.getValue());
			node.setVisited(true);
			
			boolean left = node.hasLeft() && !node.getLeft().isVisited();
			boolean right = node.hasRight() && !node.getRight().isVisited();
		
			if(right)
				stack.push(node.getRight());
			if(left)
				stack.push(node.getLeft());
		}
		tree.unmark();
		return dfs;
	}
	
	
	// parent then left, then right
	public List<Integer> postOrderDFS(Tree tree) {
		List<Integer> dfs = new ArrayList<>();
		if(tree.getRoot() == null) return dfs;
		Stack<Node> stack = new Stack<>();
		
		stack.push(tree.getRoot());
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if(node.isVisited()) continue;
			
			boolean left = node.hasLeft() && !node.getLeft().isVisited();
			boolean right = node.hasRight() && !node.getRight().isVisited();
		
			stack.push(node);
			if(right)
				stack.push(node.getRight());
			if(left)
				stack.push(node.getLeft());
			if(!left) {
				dfs.add(node.getValue());
				node.setVisited(true);
			} 
		}
		tree.unmark();
		return dfs;
		}
	
	
}

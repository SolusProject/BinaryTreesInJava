
public interface Tree {
	public Node add(Integer value);
	public boolean exists(Integer value);
	public Node find(Integer value);
	public Node remove(Integer value);
	public Node smallest();
	public Node getRoot();
	public void unmark();
}

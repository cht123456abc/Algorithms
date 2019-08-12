
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
	private Node root;
	
	//二叉查找树的数据结构
	private class Node {
		private Key key;
		private Value val;
		private Node left,right;
		private int N;//以该节点为根的子树的节点总数
		
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	//二叉查找树的算法(方法)
	//返回N
	public int size(){
		return size(root);
	}
	
	public int size(Node x) {
		if(x == null) return 0;
		else return x.N;
	}

	//查找
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return get(x.left,key);
		else if(cmp > 0) return get(x.right,key);
		return x.val;
	}

	//添加
	public void put(Key key,Value val) {
		root = put(root,key,val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return put(x.left,key,val);
		else if(cmp > 0) return put(x.right,key,val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	//最大值最小值
	public Key max() {
		return max(root).key;
	}
	
	private Node max(Node x) {
		if(x.right == null) return x;
		return max(x.right);
	}

	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x.left == null) return x;
		return min(x.left);
	}

	//向上取整，向下取整
	public Value floor(Key key) {
		return null;
	}
	
	public Value ceiling(Key key) {
		return null;
	}
	
	
}

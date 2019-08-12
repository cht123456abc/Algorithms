import java.util.Scanner;

/**
 * @author cht
 *
 */
public class UnionFind {
	private int[] parent;
	private int[] rank;
	private int count;
	
	/**
	 * 构造函数
	 * @param n
	 */
	public UnionFind(int n) {
		count = n;
		parent = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++) {
			parent[i] = i;//值等于索引
			rank[i] = 0;//初始节点等级为0
		}
	}
	
	private int count() {
		return this.count;
	}
	
	private int findRoot(int p) {
		if(p < 0 || p >= this.parent.length) throw new IllegalArgumentException("参数:"+ p +"错误！");
		while(p != parent[p]) {
			parent[p] = parent[parent[p]];//把爷爷的值传给孙子
			p = parent[p];
		}
		return p;
	}
	
	private void union(int p, int q) {
		int rootP = findRoot(p);
		int rootQ = findRoot(q);
		if(rootP == rootQ) return;
		if(rank[p] < rank[q]) parent[p] = rootQ;
		else if(rank[p] > rank[q]) parent[q] = rootP;
		else {
			parent[rootQ] = rootP;
			rank[rootP]++;
		}
		count--;
		
	}
	
	public static void main(String[] args) {
		//首先输入第一个参数n为数组总数
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		UnionFind uf = new UnionFind(n);
		while(in.hasNextLine()) {
			int p = in.nextInt();
			int q = in.nextInt();
			uf.union(p,q);
			System.out.println("rootP:" + uf.findRoot(p) + ",rootQ:" + uf.findRoot(q));
			System.out.println("当前总路径为:" + uf.count());
			if(uf.count() == 1) break;//只剩最后一条路径的时候结束union
		}
	}
}

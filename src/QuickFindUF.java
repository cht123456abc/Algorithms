import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author cht
 *
 */
public class QuickFindUF {
	private int[] id;
	private int[] rank;
	private int count;
	
	private QuickFindUF(int n) {
		this.count = n;
		id = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
			rank[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		QuickFindUF uf = new QuickFindUF(n);
		while(in.hasNextLine()) {
			int p = in.nextInt();
			int q = in.nextInt();
			uf.union(p,q);
			System.out.println("Pid:" + uf.find(p) + ",Qid:" + uf.find(q));
			System.out.println("当前的id分布:"+ Arrays.toString(uf.id));
			System.out.println("当前总路径为:" + uf.count());
			if(uf.count() == 1) break;//只剩最后一条路径的时候结束union
		}
	}

	private int count() {
		return count;
	}

	private int find(int p) {
		return id[p];
	}
	
	private void qToP(int p,int q) {
		rank[find(p)]++;
		for(int i=0;i<id.length;i++) {
			if(id[i] == find(q)) {
				id[i] = find(p);
			}
		}
	}
	
	private void union(int p, int q) {
		if(find(p) == find(q)) return;
		if(rank[find(p)] < rank[find(q)]) qToP(q,p);
		else if(rank[find(p)] > rank[find(q)]) qToP(p,q);
		else  {
			qToP(p,q);
		}
		count--;
	}
}

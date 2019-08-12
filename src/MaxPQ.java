import java.util.Arrays;

public class MaxPQ<K extends Comparable<K>>{
	private K[] pq;//基于堆的优先队列
	private int N=0;//数组长度。
	
	/**
	 * 构造函数，构造的时候初始化，赋予数组的初始大小
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public MaxPQ(int maxN) throws Exception {
		if(maxN <=0) {
			throw new Exception("容量不能小于1");
		}
		this.pq = (K[]) new Comparable[maxN+1];
	}
	
	/**
	 * 插入元素到数组的最后一位，并且当数组长度达到数组容量时，动态改变该数组的大小
	 * @return 
	 */
	private void insert(K k) {
		if(N >= pq.length) {
			//动态改变数组容量大小
			@SuppressWarnings("unchecked")
			K[] newPQ = (K[]) new Comparable[2*N];
			for(int i=0;i<N;i++) {
				newPQ[i] = pq[i];
				pq[i] = null;
			}
			this.pq = newPQ;
			//动态改变数组容量大小
			//Arrays.copyOf(pq,2*N);
		}
		pq[++N] = k;
		swim(N);
	}
	
	/**
	 * 删除堆顶，并返回
	 * @return K
	 */
	private K delMax() {
		K max = pq[1];
		pq[1] = pq[N--];
		pq[N+1] = null;
		sink(1);//再次使堆有序化
		return max;
	}
	
	/**
	 * 下沉，使堆有序化
	 * @param k
	 */
	private void sink(int k) {
		//父节点有 左右子节点中的最大值做交换
		while(2*k<=N) {
			int j = 2*k;
			if(j < N && pq[j].compareTo(pq[j+1]) < 0) j++;
			if(pq[k].compareTo(pq[j]) < 0) 
				exch(k,j);
			k = j;
		}
	}

	/**
	 * 上浮，使堆有序化
	 * @param k
	 */
	private void swim(int k) {
		while(k>1 && pq[k].compareTo(pq[k/2])>0) {
			exch(k,k/2);
			k = k/2;
		}
	}

	private void exch(int k, int i) {
		K temp = pq[k];
		pq[k] = pq[i];
		pq[i] = temp;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("rawtypes")
		MaxPQ maxPQ = new MaxPQ(5);
		System.out.println(maxPQ.pq.length);
		maxPQ.insert(new Integer(1));
		maxPQ.insert(new Integer(2));
		maxPQ.insert(new Integer(3));
		maxPQ.insert(new Integer(4));
		maxPQ.insert(new Integer(5));
		while(maxPQ.N>0) {
			System.out.println(maxPQ.delMax());
		}
	}

}

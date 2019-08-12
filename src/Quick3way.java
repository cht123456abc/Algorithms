
public class Quick3way {
	public static void sort(Comparable[] a){
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi){
		if (lo >= hi) return;
		int lt = lo,i = lo + 1,gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a,lt++,i++);
			else if(cmp > 0) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	private static void exch(Comparable[] a, int j, int i){
		Comparable swap = a[j];
		a[j] = a[i];
		a[i] = swap;
		
	}
	
	private static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}
	
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		Integer[] a = new Integer[n];
		for(int i=0;i<n;i++){
			a[i] = StdRandom.uniform(1,n);
		}
		Stopwatch timer = new Stopwatch();
		sort(a);
		System.out.println("排序时间"+timer.elapsedTime());
		show(a);
		System.out.println("排序时间"+timer.elapsedTime());
	}
}

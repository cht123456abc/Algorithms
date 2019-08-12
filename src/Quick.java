import java.util.Arrays;
import java.util.Collections;

public class Quick {
	private static int partition(Comparable[] a ,int lo , int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(a[++i].compareTo(v) < 0) if(i == hi) break;//从左边开始扫描
			while(v.compareTo(a[--j]) < 0) if(j == lo) break;//从右边开始扫描
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}
	
	private static void sort(Comparable[] a,int i, int j) {
		if(i >= j) return;
		int p = partition(a,i,j);
		sort(a,i,p-1);
		sort(a,p+1,j);
	}
	
	public static void sort(Comparable[] a) {
		sort(a,0,a.length-1);
	}
	public static void main(String[] args) {
		Integer[] input = new Integer[]{1,3,7,4,8,2,45,23,23,23,23,23,51,21,44,11,22};
		Collections.shuffle(Arrays.asList(input));
		System.out.println(Arrays.toString(input));
		sort(input);
		System.out.println(Arrays.toString(input));
	}
}

import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		Integer[] a = new Integer[]{2,45,13,43,23,51};
		Comparable[] aux = new Comparable[a.length];
		sortTB(a,aux,0,a.length-1);
		System.out.println(Arrays.toString(a));
		Integer[] a1 = {32,41,12,51,34,56};
		sortBT(a1);
		System.out.println(Arrays.toString(a1));
	}
	
	/**
	 * 归并操作，前提为左右子数组已经是排好序的状态
	 * @param a
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for(int k=lo;k<=hi;k++) {
			aux[k] = a[k];
		}
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	/**
	 * 自顶向下归并排序，采用递归
	 * @param a
	 * @param aux
	 * @param lo
	 * @param hi
	 */
	private static void sortTB(Comparable[] a,Comparable[] aux,int lo, int hi) {
		if(lo >= hi) return;
		int mid = (hi - lo)/2 + lo;
		sortTB(a,aux,lo,mid);//先排序左子树
		sortTB(a,aux,mid+1,hi);//后排序右子树
		merge(a,aux,lo,mid,hi);
	}
	
	/**
	 * 自底向上归并排序，采用分组
	 * @param a
	 */
	private static void sortBT(Comparable[] a) {
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		for(int len=1;len<n;len = 2*len) {
			for(int lo=0;lo<n-len;lo += 2*len) {
				int mid = lo + len - 1;
				int hi = Math.min(lo + 2*len -1, n-1);//当n分别为偶数奇数的边界情况
				merge(a,aux,lo,mid,hi);
			}
		}
	}
}

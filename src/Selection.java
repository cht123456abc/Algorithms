import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author cht
 *
 */
public class Selection {
	public static void sort(Comparable[] a) {
		int n = a.length;
		for(int i=0;i<n;i++) {
			int min = i;//每次循环初始选取循环的第一个为最小值
			for(int j=i+1;j<n;j++) {
				if(a[min].compareTo(a[j]) > 0 ) min = j;
			}
			swap(a,min,i);
		}
	}

	private static void swap(Comparable[] a, int min, int i) {
		Comparable<Object> temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char[] a = input.toCharArray();
		String[] b = new String[a.length];
		for(int i=0;i<a.length;i++) {
			b[i] = String.valueOf(a[i]);
		}
		System.out.println(Arrays.toString(b));
		sort(b);
		System.out.println(Arrays.toString(b));
	}
}

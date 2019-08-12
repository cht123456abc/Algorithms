import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Insertion {

	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j>0;j--) {
				if(a[j].compareTo(a[j-1]) < 0) exch(a,j,j-1);
			}
		}
	}
	private static void exch(Comparable[] a, int j, int i) {
		Comparable temp = a[j];
		a[j] = a[j-1];
		a[j-1] = temp;
		
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

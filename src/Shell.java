
public class Shell {
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		while(h>=1) {
			for(int i = h;i < N;i++){
				for(int j = i;j >= h && less(a[j],a[j-h]);j -=h){
					exch(a,j,j-h);
				}
			}
			assert isHsorted(a, h);
			h = h/3;
		}
	}

	private static void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// is the array h-sorted?
	private static boolean isHsorted(Comparable[] a, int h) {
		for (int i = h; i < a.length; i++)
			if (less(a[i], a[i - h]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);

	}
	
}

import java.awt.Color;

public class InsertionRectangle {
	 // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        
    }
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }


    // is the array a[lo..hi) sorted
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    
    public static void sort (Comparable[] a) throws InterruptedException {
    	int N = a.length;
    	for (int i=1;i<N;i++){
    		for(int j = i;j > 0 && less(a[j],a[j-1]);j--){
    			exch(a,j,j-1);
    			//交换一次后等待一段时间刷新界面
    			//每当进行交换逻辑的时候，暂缓次线程，直到绘图线程把新图刷新完成后
    			System.out.println("Thread2 exchaged");
    			Thread.sleep(100);
    			
    		}
    		assert isSorted(a,0,i);
    	}
    	assert isSorted(a);
    }
    
	public static void main(String[] args) throws InterruptedException {
		//随机可视矩形初始化
		int N = 50;
		Rectangle[] rectangles = new Rectangle[N];
		for(int i = 0;i<N;i++){
			Rectangle r = new Rectangle();
			double random = StdRandom.uniform();
			r.setValue(random);
			r.setC(Color.black);
			//r.setX(1.0*i/N);
			r.setY(r.getValue()/2.0);
			r.setHalfWidth(0.5/N);
			r.setHalfHeight(r.getValue()/2.0);
			rectangles[i]=r;
			StdDraw.filledRectangle(1.0*i/N, r.getY(), r.getHalfWidth(), r.getHalfHeight());
			//StdDraw.show(100);
		}
		
		//矩形排序
		class Draw implements Runnable {

			@Override
			public void run() {
				synchronized (this) {
					while(true){
						for (int i = 0; i < N; i++) {
							StdDraw.filledRectangle(1.0 * i / N, rectangles[i].getY(), rectangles[i].getHalfWidth(),
									rectangles[i].getHalfHeight());
						}
						try {
							System.out.println("Thread 1 running");
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		}

		class Sort implements Runnable{

			@Override
			public void run() {
				synchronized(this){
					try {
						sort(rectangles);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread 2 running");
					}
			}
			
		}
		
		Thread t1 = new Thread(new Draw());
		Thread t2 = new Thread(new Sort());
		t1.start();
		t2.start();
	}
}


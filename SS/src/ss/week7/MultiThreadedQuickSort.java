package ss.week7;


public class MultiThreadedQuickSort {
    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    public static void qsort(final int[] a, final int first, final int last) {
        if (first < last) {
            final int position = partition(a, first, last);
            Thread t1 = new Thread(new Runnable() {
            	public void run() {
            		qsort(a, first, position - 1);
            	}
            }); 
            t1.start();
            Thread t2 = new Thread(new Runnable() {
            	public void run() {
            		qsort(a, position + 1, last);
            	}
            });
            t2.start();
            try {
				t1.join();
	            t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

        }
    }
    
    public static int partition(int[] a, int first, int last) {

        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

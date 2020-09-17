import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selection {
    public static BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static String[] Input() throws IOException {
        return bfrd.readLine().split(" ");
    }

    public static void main(String[] args) throws IOException {
        String[] a = Input();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

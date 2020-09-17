import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {
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
        int N = a.length;
        int k = 1;
        while (3 * k + 1 < N) {
            k = 3 * k + 1;
        }
        while (k >= 1) {
//            System.out.println(k);
            for (int i = 0; i < k; i++) {
                for (int j = N - 1 - i; j > k; j -= k) {
                    for (int m = j; m >= 0; m -= k) {
                        if (less(a[j], a[m])) {
                            exch(a, j, m);
                        }
                    }
//                    System.out.printf("(%s,%s,%s,%s)", k, i, j, j - k);
                    show(a);
                }
            }
            k = k / 3;
        }
    }

    public static void sort2(Comparable[] a) {
        int N = a.length;
        int k = 1;
        while (3 * k + 1 < N) {
            k = 3 * k + 1;
        }
        while (k >= 1) {
            System.out.println(k);
            for (int i = 0; i <= N - 1 - k; i++) {
                for (int j = i; j < N - 1; j += k) {
                    if (less(a[j], a[i])) {
                        exch(a, i, j);
                    }
                }
            }
            k = k / 3;
            show(a);
        }
    }

    public static String[] Input() throws IOException {
        return bfrd.readLine().split(" ");
    }

    public static void main(String[] args) throws IOException {
        String[] a = Input();
        sort2(a);
        assert isSorted(a);
        show(a);
    }
}

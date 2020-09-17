import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quick {
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

    private static int Partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = Partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static String[] Input() throws IOException {
        return bfrd.readLine().split(" ");
    }

    public static double[] Input(String args) throws IOException {
        double[] a = new double[100];
        for (int i = 0; i < 100; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    public static boolean less(double v, double w) {
        return v < w;
    }

    public static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }


//        for (double number : a) {
//            System.out.print(number + " ");
//        }
//        System.out.println();
    }

    public static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static int Partition(double[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        double v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            clearEle(a, i);
            clearEle(a, j);
            exch(a, i, j);
            redrawEle(a, i);
            redrawEle(a, j);
        }
        clearEle(a, lo);
        clearEle(a, j);
        exch(a, lo, j);
        redrawEle(a, lo);
        redrawEle(a, j);
        return j;
    }

    public static void sort(double[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }

    private static void sort(double[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = Partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }


    public static void drawchange(double[] a, int i, int j) {
        clearEle(a, i);
        clearEle(a, j);
        redrawEle(a, i);
        redrawEle(a, j);
    }

    public static void clearEle(double[] a, int i) {
        int N = a.length;
        StdDraw.setPenColor(StdDraw.WHITE);
        double x = 1.0 * i / N;
        double y = a[i] / 2.0;
        double rw = 0.5 / N;
        double rh = a[i] / 2.0;
        StdDraw.filledRectangle(x, y, rw, rh);
    }

    public static void redrawEle(double[] a, int i) {
        int N = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        double x = 1.0 * i / N;
        double y = a[i] / 2.0;
        double rw = 0.5 / N;
        double rh = a[i] / 2.0;
        StdDraw.filledRectangle(x, y, rw, rh);
    }

    public static void main(String[] args) throws IOException {
        double[] a = Input("Random Doubles");
        show(a);
        StdDraw.pause(10);
        sort(a);
        assert isSorted(a);
    }


}

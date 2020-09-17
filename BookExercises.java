//import java.math.*;

public class BookExercises {
    public static void main(String[] args) {
        exercise1_1_2();
    }

    public static void exercise1_1_1() {
        int ans1_1_1_a = (0 + 15) / 2;
        double ans1_1_1_b = 2.0e-6 * 100000000.1;
        boolean ans1_1_1_c = (true && false || true && true);
        System.out.printf("(%d,%f,%s)", ans1_1_1_a, ans1_1_1_b, ans1_1_1_c);
    }

    public static void exercise1_1_2() {
        double a = (1 + 2.236) / 2;
        double b = 1 + 2 + 3 + 4.0;
        boolean c = 4.1 >= 4;
        String d = 1 + 2 + "3";
        System.out.printf("(%f,%f,%s,%s)", a, b, c, d);
    }

}

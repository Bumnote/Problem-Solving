import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static long R;
    static long y, x;

    public static void main(String[] args) {

        R = sc.nextLong(); // R: 반지름

        y = R - 1;
        x = (long) Math.sqrt(2 * R - 1);
        x = (x * x + y * y) == R * R ? x - 1 : x;

        System.out.printf("%d %d", x, y);
    }
}

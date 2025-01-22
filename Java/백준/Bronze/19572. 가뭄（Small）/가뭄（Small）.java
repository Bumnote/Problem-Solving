import java.util.*;
import java.io.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static int d1, d2, d3;

    public static void main(String[] args) {

        d1 = sc.nextInt();
        d2 = sc.nextInt();
        d3 = sc.nextInt();

        double sum = (d1 + d2 + d3) / 2.0;

        double a = sum - d3;
        double b = sum - d2;
        double c = sum - d1;

        if (a > 0 && b > 0 && c > 0) {
            System.out.println(1);
            System.out.printf("%.1f %.1f %.1f", a, b, c);
        } else System.out.println(-1);
    }

}
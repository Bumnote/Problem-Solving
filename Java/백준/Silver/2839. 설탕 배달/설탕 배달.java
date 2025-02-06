import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N, cnt;

    public static void main(String[] args) {

        N = sc.nextInt();

        cnt = 0;
        while (N > 0) {

            if (N % 5 == 0) {
                cnt += N / 5;
                N %= 5;
                break;
            }
            N -= 3;
            cnt++;
        }

        System.out.println(N == 0 ? cnt : -1);
    }
}

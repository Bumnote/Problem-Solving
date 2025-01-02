import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean flag = true;
    static long N;

    public static void main(String[] args) {

        N = sc.nextLong();

        if (N == 0)
            flag = false;

        while (N > 0) {

            if (N % 3 == 2) {
                flag = false;
                break;
            }

            N /= 3;
        }

        System.out.println(flag ? "YES" : "NO");

    }

}
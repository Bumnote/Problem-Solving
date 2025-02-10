import java.io.*;
import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static long N;

    public static void main(String[] args) {

        N = sc.nextLong(); // N: 원하는 고양이의 수
        if (N == 0)
            System.out.println(0);
        else {
            long cat = 1; // cat: 초기 고양이 수
            int cnt = 1; // cnt: 마법 횟수
            while (true) {

                if (cat == N)
                    break;

                if (cat * 2 <= N) {
                    cat *= 2;
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }

            System.out.println(cnt);
        }
    }
}
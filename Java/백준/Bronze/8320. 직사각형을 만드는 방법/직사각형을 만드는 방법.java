import java.io.*;
import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (i * j <= N) cnt++;
                else break;
            }
        }

        System.out.println(cnt);
    }
}
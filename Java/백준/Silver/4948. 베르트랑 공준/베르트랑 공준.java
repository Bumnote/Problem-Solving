import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, cnt;
    static final int MAX = 250_000;
    static boolean[] sieve = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {

        setUp();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            cnt = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (!sieve[i])
                    cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    // 에라토스테네스의 체 구현
    static void setUp() {

        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    sieve[j] = true; // 합성수 처리
                }
            }
        }

    }
}

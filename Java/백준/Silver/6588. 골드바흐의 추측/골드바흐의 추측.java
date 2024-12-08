import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int LEN = 1_000_000;
    static boolean[] sieve = new boolean[LEN + 1];

    public static void main(String[] args) throws IOException {

        int n;
        for (int i = 2; i <= LEN; i++)
            sieve[i] = true;

        // 에라토스테네스의 체 구현
        for (int i = 2; i <= (int) Math.sqrt(LEN) + 1; i++)
            if (sieve[i])
                for (int j = i * i; j <= LEN; j += i)
                    sieve[j] = false; // 합성수 제거

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            for (int i = 2; i <= (int) (n / 2); i++)
                if (sieve[i] && sieve[n - i]) {
                    bw.write(String.format("%d = %d + %d", n, i, n - i) + '\n');
                    break;
                }
        }

        bw.close();
    }
}
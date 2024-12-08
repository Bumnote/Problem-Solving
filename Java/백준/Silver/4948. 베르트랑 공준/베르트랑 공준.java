import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] sieve;
    static final int LEN = 123_456 * 2;

    public static void main(String[] args) throws IOException {

        int n, cnt;

        sieve = new boolean[LEN + 1];
        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i <= (int) Math.sqrt(LEN); i++)
            if (!sieve[i])
                for (int j = i * i; j <= LEN; j += i)
                    sieve[j] = true;

        while (true) {

            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++)
                if (!sieve[i])
                    cnt++;

            bw.write(cnt + "\n");
        }
        bw.close();
    }
}
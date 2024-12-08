import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] sieve;

    public static void main(String[] args) throws IOException {

        int n, k, cnt = 0, ans = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sieve = new boolean[n + 1]; // 기본값 false
        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) {
                cnt++;
                if (cnt == k)
                    ans = i;
                for (int j = i * 2; j <= n; j += i) {
                    if (!sieve[j]) {
                        sieve[j] = true; // 합성수 제거
                        cnt++;
                        if (cnt == k)
                            ans = j;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
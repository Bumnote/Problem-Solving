import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        int MAX = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    MAX = Math.max(MAX, dp[i]);
                }
            }
        }

        System.out.println(MAX);
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        br.close();
    }
}
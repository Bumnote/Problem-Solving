import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, SUM, MAX;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            input();

            solve();

        }

        br.close();
        // 출력 부분
        System.out.println(sb.toString());
    }

    private static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                SUM += arr[j];
                MAX = Math.max(MAX, SUM);
            }
            SUM = 0;
        }

        sb.append(MAX).append("\n");
    }

    private static void input() throws IOException {

        // 입력 부분
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        SUM = 0;
        MAX = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int C, N, SUM, CNT;
    static double AVG;
    static int[] scores;

    public static void main(String[] args) throws IOException {

        C = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= C; tc++) {

            input();

            solve();

        }

        System.out.println(sb.toString());
        br.close();
    }

    private static void solve() {

        CNT = 0;
        AVG = (double) SUM / N;
        for (int score : scores) {
            if (score > AVG)
                CNT++;
        }

        sb.append(String.format("%.3f", (double) CNT * 100 / N)).append("%").append("\n");
    }

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        SUM = 0;
        scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            SUM += scores[i];
        }
    }
}

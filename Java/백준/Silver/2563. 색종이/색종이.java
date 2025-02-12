import java.io.*;
import java.util.*;

class Main {

    static int n, y, x;
    static final int N = 100;
    static ArrayList<int[]> papers;
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cnt += map[i][j];

        System.out.println(cnt);
    }

    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int k = 0; k < n; k++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            // (3, 7)
            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        br.close();
    }
}
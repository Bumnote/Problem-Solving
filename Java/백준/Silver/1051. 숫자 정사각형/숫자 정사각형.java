import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, MAX_LENGTH, MAX;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        input();

        solve();
    }

    private static void solve() {

        for (int l = 1; l < MAX_LENGTH; l++) {
            for (int i = 0; i < N - l; i++) {
                for (int j = 0; j < M - l; j++) {
                    if (map[i][j] == map[i + l][j] && map[i + l][j] == map[i][j + l] && map[i][j + l] == map[i + l][j + l])
                        MAX = Math.max(MAX, (l + 1) * (l + 1));
                }
            }
        }

        System.out.println(MAX);
    }

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        MAX = 1;
        MAX_LENGTH = Math.min(N, M);
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        br.close();
    }
}


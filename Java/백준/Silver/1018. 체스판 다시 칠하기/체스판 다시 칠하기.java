import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, ANS = Integer.MAX_VALUE;
    static char[][] chess;

    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        int wCnt, bCnt;
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                // 모든 케이스마다 8 x 8 체스판을 확인한다.
                wCnt = 0;
                bCnt = 0;
                for (int a = i; a < i + 8; a++) {
                    for (int b = j; b < j + 8; b++) {
                        // 흰색으로 시작한 경우
                        // 짝수 - 흰색 / 홀수 - 검은색
                        if ((a + b) % 2 == 0 && chess[a][b] == 'B')
                            wCnt++;
                        if ((a + b) % 2 == 1 && chess[a][b] == 'W')
                            wCnt++;
                        // 검은색을 시작한 경우
                        // 짝수 - 검은색 / 홀수 - 흰색
                        if ((a + b) % 2 == 0 && chess[a][b] == 'W')
                            bCnt++;
                        if ((a + b) % 2 == 1 && chess[a][b] == 'B')
                            bCnt++;
                    }
                }

                MIN = Math.min(wCnt, bCnt);
                ANS = Math.min(MIN, ANS);
            }
        }

        System.out.println(ANS);
    }

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chess = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }
    }
}


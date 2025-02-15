import java.io.*;
import java.util.*;

class Main {

    static int N;
    static String seat;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        int cnt = 1; // 실제 컵홀더 개수
        int lCnt = 0; // 커플석 개수
        for (char ch : seat.toCharArray()) {
            if (ch == 'S') cnt++;
            else if (ch == 'L') {
                lCnt++;
                if (lCnt % 2 == 0) cnt++;
            }
        }
        // Min(실제 사람 수, 컵홀더 개수)
        System.out.println(Math.min(N, cnt));
    }

    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seat = br.readLine();

        br.close();
    }
}
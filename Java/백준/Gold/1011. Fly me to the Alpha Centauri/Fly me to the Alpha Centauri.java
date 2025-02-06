import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, x, y, cnt, curr, jump, nxt;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            input();

            solve();

        }

        // 출력 부분
        br.close();
        System.out.println(sb.toString());
    }

    private static void solve() {

        cnt = 1; // 한 칸 이동 후 시작

        curr = x + 1;
        jump = 1;
        while (curr < y) {

            for (int step = jump + 1; step >= jump - 1 && step > 0; step--) {
                nxt = curr + step;
                if (inRange(nxt) && canGo(curr, step)) {
                    cnt++;
                    curr = nxt;
                    jump = step;
                    break;
                }
            }

        }

        sb.append(cnt).append("\n");
    }
    // 백트래킹 구현 -> 스택 오버 플로우 -> 반복문 구현으로 변경
//    private static void bt(long curr, long jump) {
//
//        if (curr == y)
//            return;
//
//        for (long step = jump + 1; step >= jump - 1 && step > 0; step--) {
//            long nxt = curr + step;
//            // 범위를 넘지 않고, 마지막에 1칸 움직일 수 있게끔 가능하면 -> 탐색
//            if (inRange(nxt) && canGo(curr, step)) {
//                cnt++;
//                bt(nxt, step);
//                return;
//            }
//        }
//
//    }

    private static void input() throws IOException {

        // 입력 부분
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()); // 시작점
        y = Integer.parseInt(st.nextToken()); // 출발점
    }

    private static boolean inRange(long pos) {
        return x <= pos && pos <= y;
    }

    private static boolean canGo(long pos, long step) {
        return (pos + (step * (step + 1) / 2)) <= y;
    }

}

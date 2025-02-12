import java.io.*;
import java.util.*;

class Main {

    static int n, m, s, v;
    static int[] states;
    static ArrayDeque<int[]> dq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        while (!dq.isEmpty()) {
            int[] c = dq.poll();
            // 남학생인 경우 -> 토글
            if (c[0] == 1) {
                for (int i = c[1]; i <= n; i += c[1])
                    states[i] = states[i] == 1 ? 0 : 1; // 토글
            }
            // 여학생인 경우
            else {
                int s = c[1], e = c[1];
                while (1 <= s && e <= n && states[s] == states[e]) {
                    s -= 1;
                    e += 1;
                }

                for (int i = s + 1; i <= e - 1; i++)
                    states[i] = states[i] == 1 ? 0 : 1; // 범위만큼 토글
            }
        }

        // 출력 부분
        for (int i = 1; i <= n; i++) {
            if (i % 20 == 0)
                sb.append(states[i]).append("\n");
            else sb.append(states[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // n: 스위치의 개수
        states = new int[n + 1];
        dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            states[i] = Integer.parseInt(st.nextToken()); // 스위치 상태

        m = Integer.parseInt(br.readLine()); // m: 학생의 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // s - 1: 남자, 2: 여자
            v = Integer.parseInt(st.nextToken()); // v: 스위치의 개수
            dq.offer(new int[]{s, v});
        }

        br.close();
    }
}
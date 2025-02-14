import java.io.*;
import java.util.*;

class Main {

    static int L, N, p, k, cnt, wish, real;
    static int[] cake;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= L; i++) {
            if (cake[i] != 0) {
                map.put(cake[i], map.getOrDefault(cake[i], 0) + 1);
            }
        }

        int MAX = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (MAX < entry.getValue()) {
                MAX = entry.getValue();
                real = entry.getKey();
            }
        }

        // 출력 부분
        sb.append(wish).append("\n").append(real);
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine()); // L: 롤케이크의 길이
        N = Integer.parseInt(br.readLine()); // N: 방청객 수

        cake = new int[L + 1];
        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cnt = k - p + 1;
            if (MAX < cnt) {
                MAX = cnt;
                wish = i;
            }
            for (int j = p; j <= k; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                } else continue;
            }
        }

        br.close();
    }
}

import java.io.*;
import java.util.*;

class Main {

    static int N, K, first;

    public static void main(String[] args) throws IOException {

        init();

        solve();
    }

    private static void solve() {

        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++)
            dq.offer(i);

        while (dq.size() > 1) {
            first = dq.poll();

            for (int i = 1; i <= K - 1; i++)
                dq.poll();

            dq.offer(first);
        }

        System.out.println(dq.poll());
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        br.close();
    }
}
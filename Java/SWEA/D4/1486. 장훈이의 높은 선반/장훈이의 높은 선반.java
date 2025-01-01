import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, B, S, ans;
    static int[] heights;
    static boolean[] visited;
    static ArrayList<Integer> lst;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());


            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                heights[i] = Integer.parseInt(st.nextToken());

            ans = Integer.MAX_VALUE;
            visited = new boolean[N];
            lst = new ArrayList<>();
            S = 0;
            bt(lst, S);


            bw.write(String.format("#%d %d\n", tc, ans - B));
        }

        bw.close();
    }

    private static void bt(ArrayList<Integer> lst, int S) {

        if (B <= S) {
            ans = Math.min(ans, S);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!lst.isEmpty() && lst.get(lst.size() - 1) >= i)
                continue;

            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                S += heights[i];
                bt(lst, S);
                S -= heights[i];
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, A, B, cnt;
    static ArrayList<ArrayList<Integer>> vertex;
    static ArrayList<Integer> lst;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        input();

        solve();

        br.close();
        bw.close();
    }

    private static void dfs(int curr) {

        for (Integer nxt : vertex.get(curr)) {
            if (!visited[nxt]) {
                visited[nxt] = true;
                cnt++;
                lst.add(nxt);
                dfs(nxt);
            }
        }

    }

    private static void solve() throws IOException {

        int MAX = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            lst = new ArrayList<>();
            cnt = 1;
            visited[i] = true;
            dfs(i);

            if (MAX < cnt) {
                ans.clear();
                ans.add(i);
                MAX = cnt;
            } else if (MAX == cnt) ans.add(i);
        }

        Collections.sort(ans);
        for (Integer idx : ans)
            bw.write(idx + " ");
    }


    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vertex = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            vertex.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // A -> B 단방향 관계
            vertex.get(B).add(A);
        }
    }
}


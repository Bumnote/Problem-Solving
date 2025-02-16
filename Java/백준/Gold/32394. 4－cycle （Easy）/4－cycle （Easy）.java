import java.io.*;
import java.util.*;

class Main {

    static int N, M, u, v;
    static long ans;
    static boolean[] visited;
    static final int MOD = 1_000_000_007;
    static ArrayList<ArrayList<Integer>> vertex;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        ans = 0;
        for (int i = 1; i <= N; i++) {
            visited[i] = true; // 방문 처리
            dfs(i, i, 0);
            visited[i] = false; // 복원 처리
        }

        // 4개의 정점 사이클을 포함한 모든 정점을 탐색 -> 결과값 / 4
        // 시계방향, 반시계방향 중복 제거 -> 결과값 / 2
        System.out.println((ans / (4 * 2)) % MOD);
    }

    private static void dfs(int curr, int origin, int cnt) {

        if (cnt == 4)
            return;

        for (Integer nxt : vertex.get(curr)) {
            // 방문하지 않은 경우
            if (!visited[nxt]) {
                visited[nxt] = true; // 방문 처리
                dfs(nxt, origin, cnt + 1);
                visited[nxt] = false; // 복원 처리
            }
            // 4번째 정점이면서, 시작값으로 다시 돌아왔다면 -> 사이클 횟수 증가
            else if (cnt + 1 == 4 && nxt == origin) {
                ans++;
                continue;
            }
        }

    }


    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        vertex = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            vertex.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            // u <-> v: 양방향(= 무방향) 그래프
            vertex.get(u).add(v);
            vertex.get(v).add(u);
        }

        br.close();
    }
}
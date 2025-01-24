import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K, V, E, u, v;
    static ArrayList<ArrayList<Integer>> vertex;
    static int[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= K; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수

            vertex = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                vertex.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                // 양방향 간선
                vertex.get(v).add(u);
                vertex.get(u).add(v);
            }

            visited = new int[V + 1];
            flag = true;
            for (int i = 1; i <= V; i++)
                // 방문한 적이 없다면 -> 방문
                if (visited[i] == 0) {
                    visited[i] = 1; // 1로 색칠
                    dfs(i);
                }
            if (flag) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }

    private static void dfs(int curr) {

        for (int i = 0; i < vertex.get(curr).size(); i++) {
            int nxt = vertex.get(curr).get(i);
            // 다음 노드를 방문한 적이 없는 경우
            if (visited[nxt] == 0) {
                // 현재 색이 1인 경우
                if (visited[curr] == 1) {
                    visited[nxt] = 2; // 2로 색칠
                    dfs(nxt);
                } else {
                    visited[nxt] = 1; // 1로 색칠
                    dfs(nxt);
                }
            }
            // 현재 노드가 다음 노드와 색이 같다면 -> 이분 그래프가 아니다.
            else if ((visited[curr] + visited[nxt]) % 2 == 0) {
                flag = false;
                return;
            }
        }
    }
}
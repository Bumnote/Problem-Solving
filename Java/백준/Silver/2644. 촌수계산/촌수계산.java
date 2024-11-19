import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer>[] vertex;
    static boolean[] visited;
    static int ans = -1;

    public static void main(String[] args) throws IOException {

        int n, a, b, m, x, y;
        n = Integer.parseInt(br.readLine());
        vertex = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++)
            vertex[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            vertex[x].add(y);
            vertex[y].add(x);
        }

        visited[a] = true; // 시작 정점 방문 처리
        dfs(a, b, 0);
        System.out.println(ans);
    }

    private static void dfs(int cur_x, int target, int cnt) {

        if (cur_x == target) {
            ans = cnt;
            return;
        }

        for (int i = 0; i < vertex[cur_x].size(); i++) {
            if (!visited[vertex[cur_x].get(i)]) {
                visited[vertex[cur_x].get(i)] = true;
                dfs(vertex[cur_x].get(i), target, cnt + 1);
            }
        }
    }
}
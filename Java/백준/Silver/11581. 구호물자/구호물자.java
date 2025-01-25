import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int idx;

        Node(int idx) {
            this.idx = idx;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();
    static int[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];

        // 각 인덱스마다 노드 List 객체 저장
        for (int i = 0; i <= N; i++)
            vertex.add(new ArrayList<Integer>());

        // 1 ~ N - 1까지 입력
        for (int i = 1; i <= N - 1; i++) {

            int idx = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < idx; j++) {
                int nxt = Integer.parseInt(st.nextToken());
                if (!vertex.get(i).contains(nxt))
                    vertex.get(i).add(nxt); // 중복 제거
            }
        }

        // 1번 시작 -> N번 도착
        flag = false;
        dfs(1);

        System.out.println(flag ? "CYCLE" : "NO CYCLE");
    }

    private static void dfs(int curr) {

        visited[curr] = -1; // 단순 방문

        for (Integer nxt : vertex.get(curr)) {
            // 다음 노드에 방문한 적이 없다면 -> 탐색
            if (visited[nxt] == 0) {
                dfs(nxt);
            } else if (visited[nxt] == -1) {
                flag = true;
                return;
            }
        }

        visited[curr] = 1; // 모든 노드 탐색 완료
    }
}


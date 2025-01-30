import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int cost, a, b;

        Node(int cost, int a, int b) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m; // n: 컴퓨터 개수, m: 연결된 컴퓨터 쌍
    static int x, y; // x <-> y: 연결
    static int[][] mat; // mat: 비용 인접 행렬
    static int[] uf;
    static ArrayList<Node> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        setUp();

        solve();

    }

    private static void solve() throws IOException {

        int total = 0;
        int k = 0;
        ArrayList<Node> lst = new ArrayList<>();
        for (Node edge : edges) {
            int x = edge.a, y = edge.b;
            if (find(x) != find(y)) {
                union(x, y); // 집합 포함
                total += edge.cost; // 비용 증가
                k++; // 쌍 증가
                lst.add(new Node(0, x, y)); // 쌍 추가
            }
        }

        if (k == 0) {
            bw.write("0 0" + "\n");
        } else {
            bw.write(String.format("%d %d\n", total, k));
            for (Node node : lst)
                bw.write(String.format("%d %d\n", node.a, node.b));

        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (uf[x] != x)
            uf[x] = find(uf[x]);
        return uf[x];
    }

    private static void union(int x, int y) {

        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return;

        if (xRoot > yRoot) {
            int tmp = xRoot;
            xRoot = yRoot;
            yRoot = tmp;
        }

        uf[yRoot] = xRoot;
    }

    private static void setUp() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mat = new int[n][n];
        uf = new int[n + 1];
        for (int i = 0; i <= n; i++)
            uf[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            union(x, y); // 같은 집합 처리
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (i != 0 && j != 0 && i != j)
                    edges.add(new Node(mat[i][j], i + 1, j + 1));
            }
        }

        Collections.sort(edges); // 비용을 기준으로 오름차순 정렬
    }
}


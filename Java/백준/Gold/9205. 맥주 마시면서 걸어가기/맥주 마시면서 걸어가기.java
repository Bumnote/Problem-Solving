import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Edge implements Comparable<Edge> {
        int cost, v1, v2;

        Edge(int cost, int v1, int v2) {
            this.cost = cost;
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public int compareTo(Edge e) {
            return e.cost - cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, n, y, x;
    static ArrayList<Node> lst;
    static ArrayList<Edge> edges;
    static int[] uf;

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            setUp();
            solve();
        }

    }

    private static void solve() {
        // 거리 정보 저장
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 2; j++) {
                Node u = lst.get(i);
                Node v = lst.get(j);

                int dist = getDist(u.y, u.x, v.y, v.x);
                if (dist > 1000)
                    continue;
                edges.add(new Edge(dist, i + 1, j + 1));
            }
        }

        // 거리 정보 활용 - 유니온 파인드
        Collections.sort(edges); // 거리 순으로 저장

        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
            } else continue;
        }

        System.out.println(find(1) == find(n + 2) ? "happy" : "sad");

    }

    private static int find(int x) {
        if (uf[x] != x)
            uf[x] = find(uf[x]);
        return uf[x];
    }

    private static void union(int x, int y) {

        int xRoot, yRoot;
        xRoot = find(x);
        yRoot = find(y);

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

        lst = new ArrayList<>();
        edges = new ArrayList<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 2; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            lst.add(new Node(y, x)); // 모든 노드 저장
        }

        uf = new int[n + 3];
        for (int i = 0; i <= n + 2; i++)
            uf[i] = i;
    }

    private static int getDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

}


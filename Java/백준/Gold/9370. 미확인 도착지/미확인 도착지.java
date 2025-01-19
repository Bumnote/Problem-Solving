import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, t, s, g, h, a, b, d, x;
    static ArrayList<ArrayList<Node>> vertex;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            setUp();

            ArrayList<Integer> ans = getAnswer();
            for (int num : ans)
                sb.append(num).append(" ");

            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }

        bw.close();
    }

    private static ArrayList<Integer> getAnswer() throws IOException {

        ArrayList<Integer> targets = new ArrayList<>();
        int[] distS = Dijkstra(s); // 출발지에서 모든 경로의 최단 거리
        int[] distG = Dijkstra(g); // g에서 모든 경로의 최단 거리
        int[] distH = Dijkstra(h); // h에서 모든 경로의 최단 거리

        for (int j = 0; j < t; j++) {
            x = Integer.parseInt(br.readLine());

            if (distS[x] == (distS[g] + distG[h] + distH[x]) || distS[x] == (distS[h] + distH[g] + distG[x]))
                targets.add(x);
        }

        targets.sort(Comparator.naturalOrder());
        return targets;
    }

    private static int[] Dijkstra(int s) {

        int INF = 10_000_000;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.idx] != curr.cost)
                continue;

            for (int i = 0; i < vertex.get(curr.idx).size(); i++) {
                Node nxt = vertex.get(curr.idx).get(i);
                int newDist = curr.cost + nxt.cost;
                if (newDist < dist[nxt.idx]) {
                    dist[nxt.idx] = newDist;
                    pq.offer(new Node(nxt.idx, newDist));
                }
            }
        }

        return dist;
    }

    private static void setUp() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n: 교차로의 개수
        m = Integer.parseInt(st.nextToken()); // m: 도로의 개수
        t = Integer.parseInt(st.nextToken()); // t: 목적지 후보의 개수

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()); // s: 출발지
        g = Integer.parseInt(st.nextToken()); // g: 교차로의 끝점 중 하나
        h = Integer.parseInt(st.nextToken()); // h: 교차로의 끝점 중 하나

        vertex = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            vertex.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); // 양방향 도로 d
            vertex.get(a).add(new Node(b, d));
            vertex.get(b).add(new Node(a, d));
        }

    }

}


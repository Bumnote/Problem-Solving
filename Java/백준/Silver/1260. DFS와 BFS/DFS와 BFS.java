import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
	int idx;

	Node(int idx) {
	    this.idx = idx;
	}

	@Override
	public int compareTo(Node other) {
	    return Integer.compare(this.idx, other.idx);
	}
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, V;
    static ArrayList<ArrayList<Node>> vertex = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

	st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	V = Integer.parseInt(st.nextToken());

	for (int i = 0; i <= N; i++)
	    vertex.add(new ArrayList<Node>());

	for (int i = 0; i < M; i++) {
	    st = new StringTokenizer(br.readLine());

	    int v1 = Integer.parseInt(st.nextToken());
	    int v2 = Integer.parseInt(st.nextToken());

	    vertex.get(v1).add(new Node(v2));
	    vertex.get(v2).add(new Node(v1));
	}

	// 각 정점에 담긴 인덱스들을 오름차순 정렬
	for (ArrayList<Node> lst : vertex)
	    Collections.sort(lst);

	visited = new boolean[N + 1];
	dfs(V);

	bw.write("\n");
	Arrays.fill(visited, false);
	bfs(V);

	bw.close();
    }

    private static void dfs(int curr) throws IOException {

	bw.write(curr + " ");
	visited[curr] = true; // 방문 처리

	for (int i = 0; i < vertex.get(curr).size(); i++) {
	    Node nxt = vertex.get(curr).get(i);
	    // 방문하지 않은 경우 -> 탐색
	    if (!visited[nxt.idx]) {
		dfs(nxt.idx);
	    }
	}
    }

    private static void bfs(int s) throws IOException {

	ArrayDeque<Integer> dq = new ArrayDeque<>();
	dq.offer(s);
	visited[s] = true; // 방문 처리

	bw.write(s + " ");
	while (!dq.isEmpty()) {

	    int curr = dq.poll();

	    for (int i = 0; i < vertex.get(curr).size(); i++) {
		Node nxt = vertex.get(curr).get(i);
		if (!visited[nxt.idx]) {
		    bw.write(nxt.idx + " ");
		    visited[nxt.idx] = true; // 방문 처리
		    dq.offer(nxt.idx);
		}
	    }

	}

    }
}
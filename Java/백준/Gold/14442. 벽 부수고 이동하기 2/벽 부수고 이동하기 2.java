import java.util.*;
import java.io.*;

class Node {
	int y;
	int x;
	int dist;
	int kCnt;

	public Node(int y, int x, int dist, int kCnt) {
		this.y = y;
		this.x = x;
		this.dist = dist;
		this.kCnt = kCnt;
	}
}

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K;
	static int[][] MAP;
	static boolean[][][] visited;
	static int[] dys = { -1, 1, 0, 0 };
	static int[] dxs = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		MAP = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				MAP[i][j] = line.charAt(j);
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		visited = new boolean[N][M][K + 1];
		ArrayDeque<Node> dq = new ArrayDeque<>();
		dq.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = true; // 시작점 방문 처리

		while (!dq.isEmpty()) {
			Node curNode = dq.poll();

			if (curNode.y == N - 1 && curNode.x == M - 1)
				return curNode.dist;

			for (int i = 0; i < 4; i++) {
				int nxtY = curNode.y + dys[i];
				int nxtX = curNode.x + dxs[i];

				// 범위를 넘지 않고, 방문한 적이 없는 경우 -> 탐색
				if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX][curNode.kCnt]) {
					// 빈 칸인 경우
					if (MAP[nxtY][nxtX] == '0') {
						dq.add(new Node(nxtY, nxtX, curNode.dist + 1, curNode.kCnt));
						visited[nxtY][nxtX][curNode.kCnt] = true; // 방문 처리
					}
					// 벽인 경우
					else if (curNode.kCnt < K) {
						dq.add(new Node(nxtY, nxtX, curNode.dist + 1, curNode.kCnt + 1));
						visited[nxtY][nxtX][curNode.kCnt + 1] = true;
					}
				}
			}

		}
		// 방문이 불가능한 경우
		return -1;
	}

	private static boolean inRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
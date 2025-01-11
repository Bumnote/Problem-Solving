import java.io.*;
import java.util.*;

class Main {

	static class Node {
		int curr; // 스크린에 표시된 이모티콘 개수
		int board; // 클립보드에 저장된 이모티콘 개수
		int cnt; // 걸린 시간

		Node(int curr, int board, int cnt) {
			this.curr = curr;
			this.board = board;
			this.cnt = cnt;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static ArrayDeque<Node> dq = new ArrayDeque<Node>();
	static int S, MAX = 2_000;
	static boolean[][] visited = new boolean[MAX + 1][MAX + 1];

	public static void main(String args[]) throws Exception {

		S = sc.nextInt();

		int ans = bfs();

		System.out.println(ans);

	}

	private static int bfs() {

		visited[1][0] = true; // 초기 설정
		dq.offer(new Node(1, 0, 0));

		while (!dq.isEmpty()) {

			Node node = dq.poll();
			int curr = node.curr;
			int board = node.board;
			int cnt = node.cnt;

			if (curr == S)
				return cnt;

			// 현재 이모지의 개수만큼 클립보드에 넣는 경우
			if (inRange(curr) && !visited[curr][curr]) {
				visited[curr][curr] = true; // 방문 처리
				dq.offer(new Node(curr, curr, cnt + 1));
			}
			// 클립보드에 저장된 개수만큼 가져오는 경우
			if (inRange(curr + board) && !visited[curr + board][board]) {
				visited[curr + board][board] = true; // 방문 처리
				dq.offer(new Node(curr + board, board, cnt + 1));
			}
			// 현재 화면에서 이모지를 하나 삭제하는 경우
			if (inRange(curr - 1) && !visited[curr - 1][board]) {
				visited[curr - 1][board] = true; // 방문 처리
				dq.offer(new Node(curr - 1, board, cnt + 1));
			}
		}

		return -1;
	}

	private static boolean inRange(int x) {
		return 1 <= x && x <= MAX;
	}

}

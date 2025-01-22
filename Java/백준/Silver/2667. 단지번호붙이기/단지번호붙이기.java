import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, MAX;
    static int[] dys = { -1, 1, 0, 0 };
    static int[] dxs = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> lst;

    public static void main(String[] args) throws IOException {

	N = Integer.parseInt(br.readLine());
	map = new char[N][N];
	visited = new boolean[N][N];

	for (int i = 0; i < N; i++) {
	    String line = br.readLine();
	    for (int j = 0; j < N; j++) {
		map[i][j] = line.charAt(j);
	    }
	}

	lst = new ArrayList<>();
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		// 방문한 적이 없고, 1인 경우 -> 탐색
		if (!visited[i][j] && map[i][j] == '1') {
		    MAX = 1;
		    visited[i][j] = true; // 시작점 방문 처리
		    dfs(i, j);
		    lst.add(MAX);
		}
	    }
	}

	Collections.sort(lst);
	bw.write(lst.size() + "\n");

	for (int num : lst) {
	    bw.write(num + "\n");
	}

	bw.close();
	br.close();
    }

    private static void dfs(int y, int x) {

	for (int i = 0; i < 4; i++) {
	    int nxtY = y + dys[i];
	    int nxtX = x + dxs[i];
	    // 범위를 벗어나지 않고, 방문한 적이 없는 경우 -> 탐색 진행
	    if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && map[nxtY][nxtX] == '1') {
		visited[nxtY][nxtX] = true; // 방문 처리
		MAX++;
		dfs(nxtY, nxtX);
	    }
	}

    }

    private static boolean inRange(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
    }
}
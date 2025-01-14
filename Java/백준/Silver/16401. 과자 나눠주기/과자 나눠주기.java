import java.util.*;
import java.io.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N, MAX = 0; // M: 조카의 수, N: 과자의 수
	static int[] arr;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr); // 이분 탐색을 위한 오름차순 정렬 실행
		int ans = bs();
		System.out.println(ans);
	}

	private static int bs() {

		int left = 1;
		int right = 1_000_000_000;

		while (left <= right) {

			int SUM = 0;
			int mid = (left + right) / 2;

			for (int num : arr)
				SUM += (num / mid);

			if (M <= SUM) {
				if (MAX < mid)
					MAX = mid;
				left = mid + 1; // 최대 길이를 구하는 것이기 때문에 left 이동
			}
			else
				right = mid - 1;
		}

		return MAX;
	}
}

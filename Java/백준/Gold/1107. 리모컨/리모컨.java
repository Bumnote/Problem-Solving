import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, LEN, MIN = Integer.MAX_VALUE;
	static Set<Integer> excludeNumber = new HashSet<>();
	static ArrayList<Integer> lst = new ArrayList<>();
	static String str = "";
	static boolean[] canUseNumber = new boolean[10];
	static boolean[] visited = new boolean[10];
	static int closeNumber = 1_000_000;

	// 백트래킹으로 고장난 버튼을 제외한 숫자들 중에서 해당 버튼에서 가장 가까운 숫자를 찾고,
	// 그 버튼의 숫자 개수와 100번 과의 차이 , 해당 숫자와의 차이를 더하면 답이다.
	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		LEN = getLength(N);

		if (M > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				excludeNumber.add(Integer.parseInt(st.nextToken()));

			for (int i = 0; i < 10; i++)
				if (excludeNumber.contains(i))
					visited[i] = true;
		}

		bt(lst, str);
		int useBtDiff = getLength(closeNumber) + Math.abs(closeNumber - N);
		int notUseBtDiff = Math.abs(100 - N);

		System.out.println(Math.min(useBtDiff, notUseBtDiff));
	}

	private static void bt(ArrayList<Integer> lst, String currNum) {

		if (lst.size() > 6)
			return;

		if (!currNum.isEmpty()) {
			int diff = Math.abs(Integer.parseInt(currNum) - N);
			// 차이가 더 적은 수가 나오는 경우 -> 갱신
			if (MIN > diff) {
				MIN = diff; // 차이 최솟값 갱신
				closeNumber = Integer.parseInt(currNum); // 가능한 가장 가까운 숫자 갱신
			}
			// 차이가 같은 경우 -> 자릿수가 더 짧은 수로 갱신
			else if (MIN == diff) {
				int closeNumberLength = getLength(closeNumber);
				int currNumLength = getLength(Integer.parseInt(currNum));

				if (closeNumberLength > currNumLength)
					closeNumber = Integer.parseInt(currNum);
			}
		}
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				lst.add(i);
				str = str.concat(String.valueOf(i));
				bt(lst, str);
				str = str.substring(0, str.length() - 1);
				lst.remove(lst.size() - 1);
			}
		}

	}

	private static int getLength(int num) {
		int length = num == 0 ? 1 : 0;
		while (num > 0) {
			num /= 10;
			length++;
		}

		return length;
	}
}
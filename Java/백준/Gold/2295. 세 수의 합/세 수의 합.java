import java.util.*;
import java.io.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, MAX = 0;
	static int[] U;
	static Set<Integer> S;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());

		U = new int[N];
		S = new HashSet<>();
		for (int i = 0; i < N; i++)
			U[i] = Integer.parseInt(br.readLine());

		Arrays.sort(U);
		bt(0, new ArrayList<Integer>());
		int ans = getAnswer();

		System.out.println(ans);
	}

	private static int getAnswer() {

		for (int i = N - 1; i >= 0; i--)
			for (int j = 0; j < N; j++)
				if (S.contains(U[i] - U[j]))
					return U[i];

		return -1;
	}

	private static void bt(int cnt, ArrayList<Integer> lst) {

		if (cnt == 2) {
			S.add(U[lst.get(0)] + U[lst.get(1)]);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!lst.isEmpty() && lst.get(lst.size() - 1) > i)
				continue;

			lst.add(i);
			bt(cnt + 1, lst);
			lst.remove(lst.size() - 1);

		}
	}

}

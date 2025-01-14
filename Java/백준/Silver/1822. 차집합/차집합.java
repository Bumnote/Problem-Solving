import java.util.*;
import java.io.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static Set<Integer> s1 = new HashSet<>();
	static Set<Integer> s2 = new HashSet<>();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			s1.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			s2.add(Integer.parseInt(st.nextToken()));

		s1.removeAll(s2);
		int cnt = s1.size();

		sb.append(cnt).append('\n');
		if (cnt > 0) {
			Integer[] arr = s1.toArray(new Integer[0]);
			Arrays.sort(arr);
			for (int a : arr)
				sb.append(a).append(" ");
		}

		System.out.println(sb.toString());
	}
}

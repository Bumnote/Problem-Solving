import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		long x1 = 0, y1 = 0, x2 = 0, y2 = 0, px, py, q, d;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 += Integer.parseInt(st.nextToken());
			y1 += Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x2 += Integer.parseInt(st.nextToken());
			y2 += Integer.parseInt(st.nextToken());
		}

		py = y1 - y2;
		px = x1 - x2;
		d = gcd(Math.max(px, py), Math.min(px, py));
		py /= d;
		px /= d;

		if (px < 0) {
			px *= -1;
			py *= -1;
		}

		if (px == 1)
			sb.append(py);
		else
			sb.append(py).append("/").append(px);
		sb.append(" ");

		q = px * y1 - py * x1;
		px *= 4;
		d = gcd(Math.max(q, px), Math.min(q, px));
		px /= d;
		q /= d;

		if (px < 0) {
			q *= -1;
			px *= -1;
		}

		if (px == 1)
			sb.append(q);
		else
			sb.append(q).append("/").append(px);

		System.out.println(sb);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
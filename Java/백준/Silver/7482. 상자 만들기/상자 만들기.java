import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t;
  private static double[] lines;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    t = Integer.parseInt(br.readLine());

    lines = new double[t];
    for (int tc = 0; tc < t; tc++) {
      lines[tc] = Double.parseDouble(br.readLine());
    }
  }

  private static void solve() {

    // V(x) = x * x * (a - x) * 1 / 2 
    // V(x) 미분 -> V'(x) = 3x^2 - 2ax -> 0 = x(3x - 2a) -> x = 2a / 3 (a > 0)
    // a = 6b
    for (double line : lines) {
      double result = line / 6;
      sb.append(String.format("%.10f", result)).append("\n");
    }

    System.out.print(sb);
  }
}
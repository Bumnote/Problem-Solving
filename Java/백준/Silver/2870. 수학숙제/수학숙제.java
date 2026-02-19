import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static String[] strings;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    strings = new String[n];
    for (int i = 0; i < n; i++) {
      strings[i] = br.readLine();
    }

    br.close();
  }

  private static void solve() {

    PriorityQueue<BigInteger> pq = new PriorityQueue<>();
    for (String word : strings) {
      String tmp = "";
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if ('0' <= c && c <= '9') {
          tmp += String.valueOf(c);
        } else if (!tmp.isEmpty() && Character.isAlphabetic(c)) {
          pq.offer(new BigInteger(tmp));
          tmp = "";
        }
      }

      if (!tmp.isEmpty()) {
        pq.offer(new BigInteger(tmp));
      }
    }

    while (!pq.isEmpty()) {
      sb.append(pq.poll()).append("\n");
    }

    System.out.print(sb);
  }
}

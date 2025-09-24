import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static long a, b, c;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());
    c = Long.parseLong(br.readLine());
    
    br.close();
  }

  private static void solve() {
    long sum = a + b;
    if (sum >= 2 * c) System.out.println(sum - 2 * c);
    else System.out.println(sum);
  }
}
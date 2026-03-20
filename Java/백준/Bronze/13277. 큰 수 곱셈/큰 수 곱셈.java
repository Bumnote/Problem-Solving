import java.io.*;
import java.math.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static BigInteger a, b;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    a = new BigInteger(st.nextToken());
    b = new BigInteger(st.nextToken());
    br.close();
  }

  private static void solve() {
    BigInteger result = a.multiply(b);
    System.out.print(result);
  }
}
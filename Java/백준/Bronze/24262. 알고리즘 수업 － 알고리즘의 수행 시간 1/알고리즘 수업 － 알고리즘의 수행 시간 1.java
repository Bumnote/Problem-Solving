import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static long n;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Long.parseLong(br.readLine());
    br.close();
  }

  private static void solve() throws IOException {
    System.out.println(1);
    System.out.println(0);
  }
}
import java.io.*;
import java.util.*;

class Main {

  static int N;
  static int[] price;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    price = new int[N];
    for (int i = 0; i < N; i++) {
      price[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void solve() {

    Arrays.sort(price);

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      ans += (i % 3 != 0 ? price[N - i] : 0);
    }

    System.out.print(ans);
  }
}
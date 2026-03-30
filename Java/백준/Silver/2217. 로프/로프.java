import java.io.*;
import java.util.*;

class Main {


  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static Integer[] arr;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void solve() {

    Arrays.sort(arr, Collections.reverseOrder());

    int answer = arr[0];
    for (int i = 1; i < n; i++) {
      if (answer < arr[i] * (i + 1)) {
        answer = arr[i] * (i + 1);
      }
    }

    System.out.print(answer);
  }
}
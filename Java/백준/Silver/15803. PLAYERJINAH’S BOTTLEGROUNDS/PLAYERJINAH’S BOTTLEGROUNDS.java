import java.io.*;
import java.util.*;

class Main {

  static int x1, y1, x2, y2, x3, y3;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] input = new int[6];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      input[2 * i] = Integer.parseInt(st.nextToken());
      input[1 + (2 * i)] = Integer.parseInt(st.nextToken());
    }

    x1 = input[0];
    y1 = input[1];
    x2 = input[2];
    y2 = input[3];
    x3 = input[4];
    y3 = input[5];

    br.close();
  }

  private static void solve() {
    if (x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x3 * y2 - x2 * y1 == 0) {
      System.out.print("WHERE IS MY CHICKEN?");
    } else {
      System.out.println("WINNER WINNER CHICKEN DINNER!");
    }
  }
}


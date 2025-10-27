import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static int n;
  private static String[] channels;


  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    n = Integer.parseInt(br.readLine());
    channels = new String[n];
    for (int i = 0; i < n; i++) {
      channels[i] = br.readLine();
    }

    br.close();
  }

  private static void solve() {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      if (channels[i].equals("KBS1")) {
        for (int j = i; j > 0; j--) {
          swap(j, j - 1);
          sb.append("4");
        }
        break;
      }
      sb.append("1");
    }

    for (int i = 0; i < n; i++) {
      if (channels[i].equals("KBS2")) {
        if (i == 0) {
          swap(0, 1);
          sb.append("3");
        } else {
          for (int j = i; j > 1; j--) {
            swap(j, j - 1);
            sb.append("4");
          }
        }
        break;
      }
      sb.append("1");
    }

    System.out.print(sb);
  }

  private static void swap(int i, int j) {
    String tmp = channels[i];
    channels[i] = channels[j];
    channels[j] = tmp;
  }
}
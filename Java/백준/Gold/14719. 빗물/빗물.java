import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int h, w, maxHeight, minHeight;
  private static int[] blocks;


  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken()); // h: 높이
    w = Integer.parseInt(st.nextToken()); // w: 너비

    blocks = new int[w];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < w; i++) {
      blocks[i] = Integer.parseInt(st.nextToken());
      maxHeight = Math.max(maxHeight, blocks[i]);
      minHeight = Math.min(minHeight, blocks[i]);
    }

    br.close();
  }

  private static void solve() {

    int answer = 0;
    for (int height = maxHeight; height >= minHeight; height--) {
      int left, right;
      for (int j = 0; j < w; j++) {
        if (height <= blocks[j]) {
          left = j;
          right = j;
          while (inRange(right + 1)) {
            if (blocks[right + 1] >= height) {
              answer += right - left;
              break;
            }
            right++;
          }
        }
      }
    }

    System.out.print(answer);
  }

  private static boolean inRange(int x) {
    return 0 <= x && x < w;
  }
}
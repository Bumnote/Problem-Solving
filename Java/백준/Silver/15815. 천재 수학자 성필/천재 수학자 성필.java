import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String word;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    word = br.readLine();
    br.close();
  }

  private static void solve() {

    Deque<Integer> dq = new ArrayDeque<>();

    for (char c : word.toCharArray()) {
      if (Character.isDigit(c)) {
        dq.offer(c - '0');
      } else {
        int a = dq.pollLast();
        int b = dq.pollLast();
        if (c == '*') {
          dq.offer(a * b);
        } else if (c == '+') {
          dq.offer(a + b);
        } else if (c == '-') {
          dq.offer(b - a);
        } else if (c == '/') {
          dq.offer(b / a);
        }
      }
    }

    int result = dq.poll();
    System.out.print(result);
  }
}
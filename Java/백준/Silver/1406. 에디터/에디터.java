import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;

  static int N, M;
  static LinkedList<Character> ll;
  static ListIterator<Character> iter;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    ll = new LinkedList<>();
    iter = ll.listIterator();
    char[] input = br.readLine().toCharArray();
    for (char c : input) {
      iter.add(c);
    }

    N = ll.size(); // 문자열의 길이
    M = Integer.parseInt(br.readLine()); // M: 명령어의 개수
  }

  private static void solve() throws IOException {

    int cursor = N; // 명령어 수행 전 커서의 위치는 문장의 맨 뒤
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      char command = st.nextToken().charAt(0);
      switch (command) {
        case 'L':
          if (iter.hasPrevious()) {
            iter.previous();
          }
          break;
        case 'D':
          if (iter.hasNext()) {
            iter.next();
          }
          break;
        case 'B':
          if (iter.hasPrevious()) {
            iter.previous();
            iter.remove();
          }
          break;
        case 'P':
          char c = st.nextToken().charAt(0);
          iter.add(c);
          break;
      }
    }

    for (char c : ll) {
      bw.write(c);
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String A, B; // A -> B
  private static LinkedList<Character> ld = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    A = br.readLine();
    B = br.readLine();

    for (char c : A.toCharArray()) {
      ld.add(c);
    }

    br.close();
  }

  private static void solve() {

    char[] arrA = A.toCharArray();
    char[] arrB = B.toCharArray();
    Arrays.sort(arrA);
    Arrays.sort(arrB);

    // 길이가 맞지 않으면 -> A를 B로 만들 수 없다.
    if (arrA.length != arrB.length) {
      System.out.print(-1);
      return;
    }

    // 정렬했을 때, 구성이 다르다면 -> A를 B로 만들 수 없다.
    for (int i = 0; i < arrA.length; i++) {
      if (arrA[i] != arrB[i]) {
        System.out.print(-1);
        return;
      }
    }

    int ans = A.length();
    int idx = A.length() - 1;
    for (int i = idx; i >= 0; i--) {
      if (A.charAt(i) == B.charAt(idx)) {
        idx--;
        ans--;
      }
    }

    System.out.print(ans);
  }
}
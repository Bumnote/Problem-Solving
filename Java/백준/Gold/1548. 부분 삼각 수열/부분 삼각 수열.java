import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] A;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    A = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    Arrays.sort(A); // 오름차순 정렬

    int sequenceLength = 1;
    for (int left = 0; left < n - 1; left++) {
      for (int right = n - 1; right >= left + 1; right--) {
        if (isTriRelation(A[left], A[left + 1], A[right])) {
          sequenceLength = Math.max(sequenceLength, right - left + 1);
          break;
        }
      }
    }

    if (sequenceLength == 1 && n >= 3) {
      sequenceLength = 2;
    }

    System.out.print(sequenceLength);
  }

  private static boolean isTriRelation(int x, int y, int z) {
    return (x + y > z) && (x + z > y) && (y + z > x);
  }
}
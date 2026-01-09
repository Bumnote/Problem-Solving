import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[] times;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    times = new int[n];
    for (int i = 0; i < n; i++) {
      times[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(times);
    br.close();
  }

  private static void solve() {

    long left = 1;
    long right = (long) times[n - 1] * m;
    long answer = right;
    while (left <= right) {
      long mid = (left + right) / 2;
      long totalPerson = calculatePersonCount(mid);

      // 인원 수와 같거나 많이 심사할 수 있는 경우 -> right 감소
      if (totalPerson >= m) {
        answer = Math.min(answer, mid);
        right = mid - 1;
      }
      // 인원 수보다 적게 심사할 수 있는 경우 -> left 증가
      else {
        left = mid + 1;
      }
    }

    System.out.print(answer);
  }

  private static long calculatePersonCount(long mid) {
    long totalPerson = 0;
    for (int time : times) {
      totalPerson += mid / time;
      if (totalPerson >= m) {
        return totalPerson;
      }
    }

    return totalPerson;
  }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] numbers, increase, decrease;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {
    increase = new int[n];
    decrease = new int[n];

    Arrays.fill(increase, 1);
    Arrays.fill(decrease, 1);

    for (int i = 1; i < n; i++) {
      int count = 0;
      for (int j = 0; j < i; j++) {
        if (numbers[j] < numbers[i]) {
          count = Math.max(count, increase[j]);
        }
      }
      increase[i] += count;
    }

    for (int i = n - 2; i >= 0; i--) {
      int count = 0;
      for (int j = i + 1; j < n; j++) {
        if (numbers[i] > numbers[j]) {
          count = Math.max(count, decrease[j]);
        }
      }
      decrease[i] += count;
    }

    int answer = 1;
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, increase[i] + decrease[i] - 1);
    }

    System.out.print(answer);
  }
}
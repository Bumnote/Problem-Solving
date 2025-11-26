import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    int left = 0;
    int right = 0;
    final Set<Integer> set = new HashSet<>();

    long answer = 0;
    while (right < n) {
      // 현재 수가 이미 집합에 존재한다면 ->
      if (set.contains(numbers[right])) {
        // left가 중복된 수를 가리킬 때까지 left++
        for (int i = left; i <= right; i++) {
          answer += (right - i);
          left++;
          if (numbers[i] == numbers[right]) {
            break;
          }
          set.remove(numbers[i]);
        }
      }
      // 현재 수가 집합에 존재하지 않는다면 -> right++
      else {
        set.add(numbers[right]);
      }
      right++;
    }

    answer += (long) (right - left) * (right - left + 1) / 2;

    System.out.print(answer);
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int a, b, c;
  private static final List<int[]> numbers = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    while (true) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0) {
        break;
      }
      numbers.add(new int[]{a, b, c});
    }
    br.close();
  }


  private static void solve() {

    for (int[] number : numbers) {
      a = number[0];
      b = number[1];
      c = number[2];

      if (a == b && b == c) {
        if (a == 0) {
          break;
        }
        System.out.println("Equilateral");
      } else if (a + b <= c || b + c <= a || c + a <= b) {
        System.out.println("Invalid");
      } else if (a != b && b != c && c != a) {
        System.out.println("Scalene");
      } else {
        System.out.println("Isosceles");
      }
    }
  }
}
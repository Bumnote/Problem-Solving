import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[] A, B;
  private static List<Integer> intersection = new ArrayList<>();

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

    m = Integer.parseInt(br.readLine());
    B = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    ArrayList<Integer> intersection = new ArrayList<>();

    int maxValueAIndex = 0;
    int maxValueBIndex = 0;
    while (maxValueAIndex < n && maxValueBIndex < m) {
      int MAX = -1;
      int tmpAIndex = maxValueAIndex;
      int tmpBIndex = maxValueBIndex;
      for (int i = maxValueAIndex; i < n; i++) {
        for (int j = maxValueBIndex; j < m; j++) {
          if (A[i] == B[j]) {
            if (MAX < A[i]) {
              MAX = A[i];
              tmpAIndex = i;
              tmpBIndex = j;
            }
          }
        }
      }

      if (MAX != -1) {
        intersection.add(MAX);
      }

      maxValueAIndex = tmpAIndex + 1;
      maxValueBIndex = tmpBIndex + 1;
    }

    System.out.println(intersection.size());
    if (!intersection.isEmpty()) {
      for (int num : intersection) {
        sb.append(num).append(" ");
      }
      System.out.print(sb);
    }
  }
}

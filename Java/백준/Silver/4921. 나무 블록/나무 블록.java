import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String n;

  public static void main(String[] args) throws Exception {

    int tc = 1;
    while (true) {
      n = br.readLine();
      if (n.equals("0")) {
        break;
      }
      solve(tc++);
    }

    System.out.print(sb);
  }

  private static void solve(int tc) {

    int size = n.length();
    // 1번 조건
    if (size == 1 || (n.charAt(0) != '1' || n.charAt(size - 1) != '2')) {
      sb.append(tc).append(". ").append("NOT").append("\n");
      return;
    }

    for (int i = 1; i < size - 1; i++) {
      // 2번 조건 -> 4, 5번 조각
      // 4번 조각
      if (n.charAt(i) == '4') {
        if (n.charAt(i - 1) != '1' && n.charAt(i - 1) != '3') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
        if (n.charAt(i + 1) != '3' && n.charAt(i + 1) != '2') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }
      // 5번 조각
      else if (n.charAt(i) == '5') {
        if (n.charAt(i - 1) != '1' && n.charAt(i - 1) != '3') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
        if (n.charAt(i + 1) != '8') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }
      // 3번 조건 -> 1번 조각과 2번 조각이 중간에 나오는 경우
      else if (n.charAt(i) == '1' || n.charAt(i) == '2') {
        sb.append(tc).append(". ").append("NOT").append("\n");
        return;
      }
      // 8번 조각
      else if (n.charAt(i) == '8') {
        if (n.charAt(i - 1) != '5' && n.charAt(i - 1) != '7') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
        if (n.charAt(i + 1) != '6' && n.charAt(i + 1) != '7') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }
      // 7번 조각
      else if (n.charAt(i) == '7') {
        if (n.charAt(i - 1) != '8' || n.charAt(i + 1) != '8') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }

      // 6번 조각
      else if (n.charAt(i) == '6') {
        if (n.charAt(i - 1) != '8' || (n.charAt(i + 1) != '2' && n.charAt(i + 1) != '3')) {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }
      // 3번 조각
      else if (n.charAt(i) == '3') {
        if (n.charAt(i - 1) != '4' && n.charAt(i - 1) != '6') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
        if (n.charAt(i + 1) != '4' && n.charAt(i + 1) != '5') {
          sb.append(tc).append(". ").append("NOT").append("\n");
          return;
        }
      }
    }

    sb.append(tc).append(". ").append("VALID").append("\n");
    return;
  }
}

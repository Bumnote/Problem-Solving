import java.io.*;
import java.util.*;

class Main {

  static int N;
  static ArrayDeque<Integer> stk, tmp, space;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    N = Integer.parseInt(br.readLine());
    stk = new ArrayDeque<>();
    tmp = new ArrayDeque<>();
    space = new ArrayDeque<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      stk.add(Integer.parseInt(st.nextToken()));
      tmp.add(i);
    }
    br.close();
  }

  private static void solve() {

    while (!stk.isEmpty()) {
      // 줄 서 있는 곳에서 바로 간식을 받을 수 있는 경우 -> 제거한다.
      if (stk.peekFirst().equals(tmp.peekFirst())) {
        tmp.pollFirst();
        stk.pollFirst();
      }
      // 줄 서 있는 곳에서 바로 간식을 받을 수 없는 경우 -> 대기열 추가
      else {
        // 대기열에 사람이 존재하고, 대기열에서 순서가 맞는 사람이 있는 경우 -> 제거 후, 추가
        while (!space.isEmpty() && space.peekLast().equals(tmp.peekFirst())) {
          space.pollLast();
          tmp.pollFirst();
        }
        space.add(stk.pollFirst());
      }
    }

    // 대기열의 사람이 존재하는 경우 -> 순서대로 간식을 받을 수 있어야 한다.
    while (!space.isEmpty()) {
      int x = space.pollLast();
      if (x == tmp.peekFirst()) {
        tmp.pollFirst();
      } else {
        System.out.print("Sad");
        return;
      }
    }

    System.out.print("Nice");
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

  static class Queue {

    ArrayDeque<Integer> dq;
    int itemCount;

    Queue() {
      this.itemCount = 0;
      this.dq = new ArrayDeque<>();
    }

    void push(int x) {
      this.dq.offer(x);
    }

    int pop() {
      if (this.dq.isEmpty()) {
        return -1;
      } else {
        return this.dq.pollFirst();
      }
    }

    int size() {
      return this.dq.size();
    }

    int empty() {
      if (this.dq.isEmpty()) {
        return 1;
      } else {
        return 0;
      }
    }

    int front() {
      if (this.dq.isEmpty()) {
        return -1;
      } else {
        return this.dq.getFirst();
      }
    }

    int back() {
      if (this.dq.isEmpty()) {
        return -1;
      } else {
        return this.dq.getLast();
      }
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int tc;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    tc = Integer.parseInt(br.readLine());
  }

  private static void solve() throws IOException {
    Queue q = new Queue();
    for (int i = 0; i < tc; i++) {
      st = new StringTokenizer(br.readLine());
      if (st.countTokens() == 1) {
        String command = st.nextToken();
        switch (command) {
          case "pop":
            sb.append(q.pop()).append('\n');
            break;
          case "size":
            sb.append(q.size()).append('\n');
            break;
          case "empty":
            sb.append(q.empty()).append('\n');
            break;
          case "front":
            sb.append(q.front()).append('\n');
            break;
          case "back":
            sb.append(q.back()).append('\n');
            break;
          default:
            break;
        }
      } else {
        String command = st.nextToken();
        int x = Integer.parseInt(st.nextToken());
        q.push(x);
      }
    }

    System.out.print(sb);
  }
}
import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, M, IDX, SIZE;
  static int[] arr;
  static PriorityQueue<Integer> maxHeap; // 내림차순 정렬
  static PriorityQueue<Integer> minHeap; // 오름차순 정렬

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve();
      sb.append("\n");
    }
    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {

    M = Integer.parseInt(br.readLine());

    arr = new int[M + 1];
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    minHeap = new PriorityQueue<>();

    IDX = 1;
    SIZE = M % 10 == 0 ? M / 10 : (M / 10) + 1;
    for (int i = 0; i < SIZE; i++) {
      st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        arr[IDX++] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void solve() {

    sb.append((M + 1) / 2).append("\n"); // 중앙값 개수
    // 원소의 개수가 1개 이하인 경우 -> 해당 값 바로 저장
    if (M <= 1) {
      sb.append(arr[1]).append(" ");
      return;
    }

    heapInit();
    for (int i = 3; i <= M; i++) {
      // maxHeap의 가장 큰 값보다 값이 큰 경우 -> minHeap 저장
      if (maxHeap.peek() < arr[i]) {
        minHeap.add(arr[i]);
        if (i % 2 == 1) {
          sb.append(minHeap.peek()).append(" ");
        }
      }
      // maxHeap의 가장 큰 값보다 값이 작거나 같은 경우 -> maxHeap 저장
      else {
        maxHeap.add(arr[i]);
        if (i % 2 == 1) {
          sb.append(maxHeap.peek()).append(" ");
        }
      }

      // 10번째 수를 저장한 경우 -> 줄바꿈 문자 추가
      if (i % 20 == 0 && i != M) {
        sb.append("\n");
      }

      heapHeightMakeSame();
    }
  }

  private static void heapInit() {

    sb.append(arr[1]).append(" "); // 초기화
    if (arr[1] < arr[2]) {
      maxHeap.add(arr[1]);
      minHeap.add(arr[2]);
    } else {
      maxHeap.add(arr[2]);
      minHeap.add(arr[1]);
    }
  }

  private static void heapHeightMakeSame() {

    // 높이가 2개 차이가 나면 -> 높이를 같게 해준다.
    // maxHeap 높이가 더 높은 경우
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() + 1 < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }
}

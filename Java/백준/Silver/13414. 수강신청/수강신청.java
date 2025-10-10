import java.io.*;
import java.util.*;

class Main {

  static class Student implements Comparable<Student> {
    String studentNumber;
    int index;

    Student(String studentNumber, int index) {
      this.studentNumber = studentNumber;
      this.index = index;
    }

    @Override
    public int compareTo(Student o) {
      return Integer.compare(this.index, o.index);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static int k, l;
  private static final Map<String, Integer> map = new HashMap<>();
  private static final PriorityQueue<Student> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    for (int i = 0; i < l; i++) {
      String studentNumber = br.readLine();
      // 이미 한번 수강 신청을 한 경우 -> 제거 인덱스 정보 저장
      map.put(studentNumber, i);
    }
    br.close();
  }

  private static void solve() {

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(new Student(entry.getKey(), entry.getValue()));
    }

    int count = 0;
    while (!pq.isEmpty() && count < k) {
      Student student = pq.poll();
      sb.append(student.studentNumber).append("\n");
      count++;
    }

    System.out.print(sb);
    sb.setLength(0);
  }
}
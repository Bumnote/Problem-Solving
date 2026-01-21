import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  static class Person {

    int id;
    int korean;
    int english;
    int math;
    int science;

    Person(int id, int korean, int english, int math, int science) {
      this.id = id;
      this.korean = korean;
      this.english = english;
      this.math = math;
      this.science = science;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;

  private static final Set<Integer> studentIds = new HashSet<>();
  private static PriorityQueue<Person> koreanScores = new PriorityQueue<>((o1, o2) -> {
    if (o1.korean == o2.korean) {
      return Integer.compare(o1.id, o2.id);
    }
    return Integer.compare(o2.korean, o1.korean);
  });
  private static PriorityQueue<Person> englishScores = new PriorityQueue<>((o1, o2) -> {
    if (o1.english == o2.english) {
      return Integer.compare(o1.id, o2.id);
    }
    return Integer.compare(o2.english, o1.english);
  });
  private static PriorityQueue<Person> mathScores = new PriorityQueue<>((o1, o2) -> {
    if (o1.math == o2.math) {
      return Integer.compare(o1.id, o2.id);
    }
    return Integer.compare(o2.math, o1.math);
  });
  private static PriorityQueue<Person> scienceScores = new PriorityQueue<>((o1, o2) -> {
    if (o1.science == o2.science) {
      return Integer.compare(o1.id, o2.id);
    }
    return Integer.compare(o2.science, o1.science);
  });

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int korean = Integer.parseInt(st.nextToken());
      int english = Integer.parseInt(st.nextToken());
      int math = Integer.parseInt(st.nextToken());
      int science = Integer.parseInt(st.nextToken());

      Person person = new Person(id, korean, english, math, science);
      koreanScores.add(person);
      englishScores.add(person);
      mathScores.add(person);
      scienceScores.add(person);
    }
    br.close();
  }

  public static void solve() {

    Set<Integer> studentIds = new HashSet<>();

    Person koreanTop = koreanScores.poll();
    sb.append(koreanTop.id).append(" ");
    studentIds.add(koreanTop.id);

    while (!englishScores.isEmpty()) {
      Person englishTop = englishScores.poll();
      if (!studentIds.contains(englishTop.id)) {
        sb.append(englishTop.id).append(" ");
        studentIds.add(englishTop.id);
        break;
      }
    }

    while (!mathScores.isEmpty()) {
      Person mathTop = mathScores.poll();
      if (!studentIds.contains(mathTop.id)) {
        sb.append(mathTop.id).append(" ");
        studentIds.add(mathTop.id);
        break;
      }
    }

    while (!scienceScores.isEmpty()) {
      Person scienceTop = scienceScores.poll();
      if (!studentIds.contains(scienceTop.id)) {
        sb.append(scienceTop.id).append(" ");
        studentIds.add(scienceTop.id);
        break;
      }
    }

    System.out.print(sb);
  }
}

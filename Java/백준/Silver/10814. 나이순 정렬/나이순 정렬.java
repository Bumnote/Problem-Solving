import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person> {
        int age, order;
        String name;

        Person(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age != o.age)
                return this.age - o.age;
            return this.order - o.order;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, age;
    static String name;
    static ArrayList<Person> lst;

    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        Collections.sort(lst);

        for (Person p : lst)
            sb.append(p.age).append(" ").append(p.name).append("\n");

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {

        N = Integer.parseInt(br.readLine());

        lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            lst.add(new Person(age, i, name));
        }

        br.close();
    }

}

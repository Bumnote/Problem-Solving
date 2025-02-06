import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person> {
        String name;
        int kor, eng, mat;

        Person(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }

        @Override
        public int compareTo(Person o) {
            if (this.kor != o.kor)
                return o.kor - this.kor; // 내림차순
            if (this.eng != o.eng)
                return this.eng - o.eng; // 오름차순
            if (this.mat != o.mat)
                return o.mat - this.mat; // 내림차순
            return this.name.compareTo(o.name); // 오름차순
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, kor, eng, mat;
    static String name;
    static ArrayList<Person> lst;

    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        // 정렬
        Collections.sort(lst);

        // 출력 부분
        for (Person p : lst)
            sb.append(p.name).append("\n");
        System.out.println(sb.toString());
    }


    private static void input() throws IOException {

        // 입력 부분
        N = Integer.parseInt(br.readLine());

        lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            kor = Integer.parseInt(st.nextToken());
            eng = Integer.parseInt(st.nextToken());
            mat = Integer.parseInt(st.nextToken());
            lst.add(new Person(name, kor, eng, mat));
        }

        br.close();
    }
}

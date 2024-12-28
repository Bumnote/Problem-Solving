import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b, c, n; // a: 일반, b: 특별, c: 서비스
    static long sumA = 0, sumB = 0, cnt = 0, total = 0;

    static Map<String, Integer> general = new HashMap<>();
    static Map<String, Integer> special = new HashMap<>();
    static Set<String> service = new HashSet<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Integer price = Integer.parseInt(st.nextToken());

            general.put(name, price);
        }

        for (int j = 0; j < b; j++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Integer price = Integer.parseInt(st.nextToken());

            special.put(name, price);
        }

        for (int k = 0; k < c; k++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            service.add(name);
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            // 일반 메뉴인 경우
            if (general.containsKey(name))
                sumA += general.get(name);

            // 특별 메뉴인 경우
            if (special.containsKey(name))
                sumB += special.get(name);

            // 서비스 메뉴인 경우
            if (service.contains(name))
                cnt++;
        }

        boolean isTrue = judge();
        System.out.println(isTrue ? "Okay" : "No");

    }

    private static boolean judge() {

        total = sumA + sumB;
        // 일반 메뉴의 가격이 20_000원이 넘는 경우
        if (sumA >= 20_000) {
            // 특별 메뉴를 구매한 경우
            if (sumB >= 0) {
                return (total >= 50_000 && cnt <= 1) || (total < 50_000 && cnt == 0);
            }
        }

        return sumA < 20_000 && sumB == 0 && cnt == 0;
    }
}

import java.io.*;
import java.util.*;

class Main {

    static int n, sum, remain;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        StringBuilder sb = new StringBuilder();
        remain = sum - 100;
        for (int i = 1; i <= remain / 2; i++) {
            if (set.contains(i) && set.contains(remain - i)) {
                set.remove(i);
                set.remove(remain - i);
                break;
            }
        }

        ArrayList<Integer> lst = new ArrayList<>(set);
        Collections.sort(lst);

        for (Integer num : lst)
            sb.append(num).append("\n");

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sum = 0;
        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            n = Integer.parseInt(br.readLine());
            set.add(n);
            sum += n;
        }

        br.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String tree;
    static int CNT;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        input();

        solve();
    }

    private static void solve() {

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String s : keySet) {
            tree = s;
            sb.append(tree).append(" ").append(String.format("%.4f\n", (double) map.get(tree) * 100 / CNT));
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {

        tree = null;
        while ((tree = br.readLine()) != null) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            CNT++;
        }

        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr_n;
    static int[] arr_m;
    static int n, m, MIN, MAX;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr_n = new int[n];
        for (int i = 0; i < n; i++)
            arr_n[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr_m = new int[m];
        for (int i = 0; i < m; i++)
            arr_m[i] = Integer.parseInt(st.nextToken());

        MIN = Integer.MAX_VALUE;
        MAX = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= m; j++) {
                List<Integer> lst = new ArrayList<>();
                for (int k = 0; k < m; k += j) {
                    if (i + k >= m)
                        continue;
                    lst.add(arr_m[i + k]);
                    if (lst.size() == n) {
                        if (judgeEquals(arr_n, lst)) {
                            MIN = Math.min(MIN, j - 1);
                            MAX = Math.max(MAX, j - 1);
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(MAX != -1 ? String.format("%d %d", MIN, MAX) : -1);
    }

    private static boolean judgeEquals(int[] arr, List<Integer> lst) {

        boolean flag = true;
        for (int i = 0; i < n; i++)
            if (arr[i] != lst.get(i)) {
                flag = false;
                break;
            }
        return flag;
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, diff, GCD, ans = 0;

    static ArrayList<Integer> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            lst.add(Integer.parseInt(br.readLine()));

        lst.sort(Comparator.naturalOrder());
        GCD = lst.get(1) - lst.get(0);
        for (int i = 0; i < N - 1; i++) {
            diff = lst.get(i + 1) - lst.get(i);
            GCD = getGCD(GCD, diff);
        }

        for (int i = 0; i < N - 1; i++) {
            diff = lst.get(i + 1) - lst.get(i);
            ans += (diff / GCD) - 1;
        }

        System.out.println(ans);
    }

    private static int getGCD(int a, int b) {

        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b > 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}

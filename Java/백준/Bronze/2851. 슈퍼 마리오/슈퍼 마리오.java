import java.io.*;
import java.util.*;

class Main {

    static int[] grade = new int[10];

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {
        int SUM = 0, MIN = Integer.MAX_VALUE, MAX = 0;
        for (int i = 0; i < 10; i++) {
            SUM += grade[i];
            if (MIN >= Math.abs(100 - SUM)) {
                MIN = Math.abs(100 - SUM);
                if (MAX < SUM) {
                    MAX = SUM;
                }
            }
        }

        System.out.println(MAX);
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
            grade[i] = Integer.parseInt(br.readLine());

        br.close();
    }

}

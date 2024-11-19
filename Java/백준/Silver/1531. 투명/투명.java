import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {

        int n, m, y1, x1, y2, x2, total = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            setPaper(y1, x1, y2, x2);
        }

        for (int i = 1; i < 101; i++)
            for (int j = 1; j < 101; j++)
                if (arr[i][j] > m) total++;

        System.out.println(total);

    }

    private static void setPaper(int y1, int x1, int y2, int x2) {

        for (int i = y1; i <= y2; i++)
            for (int j = x1; j <= x2; j++)
                arr[i][j]++;

    }
}
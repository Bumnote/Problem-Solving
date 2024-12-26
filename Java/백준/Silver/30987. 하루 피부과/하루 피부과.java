import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int x1, x2; // (x1, 0) ~ (x2, 0)
        int a, b, c, d, e;
        double ans;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        b = b - d;
        c = c - e;

        ans = (((double) a / 3) * Math.pow(x2, 3) + (double) b / 2 * Math.pow(x2, 2) + c * x2) -
                (((double) a / 3) * Math.pow(x1, 3) + (double) b / 2 * Math.pow(x1, 2) + c * x1);

        System.out.println((int) ans);

    }
}
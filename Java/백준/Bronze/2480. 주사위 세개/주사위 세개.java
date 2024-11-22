import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int a, b, c;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (a == b && b == c)
            System.out.println(10_000 + a * 1_000);
        else if (a != b && b != c && c != a)
            System.out.println(Math.max(Math.max(a, b), c) * 100);
        else {
            if (a == b)
                System.out.println(1_000 + a * 100);
            else if (b == c)
                System.out.println(1_000 + b * 100);
            else
                System.out.println(1_000 + c * 100);
        }

    }
}
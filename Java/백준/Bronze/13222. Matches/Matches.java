import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n, w, h, length;
        double diagonal;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        diagonal = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
        for (int i = 0; i < n; i++) {
            length = Integer.parseInt(br.readLine());
            System.out.println(length <= diagonal ? "YES" : "NO");
        }

    }
}
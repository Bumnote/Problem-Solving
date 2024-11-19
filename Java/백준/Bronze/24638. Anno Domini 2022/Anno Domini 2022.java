import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        String a, b, c, d;
        int x = 0, y = 0;
        a = st.nextToken();
        b = st.nextToken();

        if (a.equals("AD"))
            x = Integer.parseInt(b) - 1;
        else
            x = -Integer.parseInt(a);

        st = new StringTokenizer(br.readLine());
        c = st.nextToken();
        d = st.nextToken();
        if (c.equals("AD"))
            y = Integer.parseInt(d) - 1;
        else
            y = -Integer.parseInt(c);

        bw.write(Math.abs(x - y) + "\n");
        bw.flush();
        bw.close();
    }
}
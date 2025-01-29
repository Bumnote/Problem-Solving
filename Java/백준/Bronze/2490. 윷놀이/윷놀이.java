import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Character> map = new HashMap<Integer, Character>() {{
        put(0, 'D');
        put(1, 'C');
        put(2, 'B');
        put(3, 'A');
        put(4, 'E');
    }};

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 3; i++) {
            int num = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                num += Integer.parseInt(st.nextToken());

            System.out.println(map.get(num));
        }
    }
}


import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Integer[] arr_b, arr_c, arr_d;

    public static void main(String[] args) throws IOException {

        int b, c, d, MIN, total = 0, discount = 0;
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr_b = new Integer[b];
        arr_c = new Integer[c];
        arr_d = new Integer[d];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arr_b[i] = Integer.parseInt(st.nextToken());
            total += arr_b[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr_c[i] = Integer.parseInt(st.nextToken());
            total += arr_c[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            arr_d[i] = Integer.parseInt(st.nextToken());
            total += arr_d[i];
        }
        MIN = Math.min(Math.min(b, c), d);

        Arrays.sort(arr_b, Collections.reverseOrder());
        Arrays.sort(arr_c, Collections.reverseOrder());
        Arrays.sort(arr_d, Collections.reverseOrder());

        for (int i = 0; i < MIN; i++) {
            discount += arr_b[i];
            discount += arr_c[i];
            discount += arr_d[i];
        }

        discount = (int) ((total - discount) + discount * 0.9);
        System.out.println(total);
        System.out.println(discount);

    }
}
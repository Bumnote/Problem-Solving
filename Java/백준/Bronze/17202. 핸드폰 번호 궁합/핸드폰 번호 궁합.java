import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] arr = new int[16][2];
    static int[] arr_n = new int[8];
    static int[] arr_m = new int[8];
    static String[] str = new String[8];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        str = st.nextToken().split("");
        for (int i = 0; i < str.length; i++) {
            arr_n[i] = Integer.parseInt(str[i]);
            arr[i * 2][0] = arr_n[i];
        }

        st = new StringTokenizer(br.readLine());
        str = st.nextToken().split("");
        for (int i = 0; i < str.length; i++) {
            arr_m[i] = Integer.parseInt(str[i]);
            arr[i * 2 + 1][0] = arr_m[i];
        }

        for (int i = 1; i < 16; i++) {
            for (int j = i; j < 16; j++) {
                arr[j][1] = (arr[j - 1][0] + arr[j][0]) % 10;
            }

            if (i == 15)
                break;
            for (int k = i; k < 16; k++)
                arr[k][0] = arr[k][1];
        }

        System.out.printf("%d%d\n", arr[14][0], arr[15][0]);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static String N;
    static int SUM;
    static char[] arr;

    public static void main(String[] args) throws IOException {

        N = sc.nextLine();
        SUM = 0;

        for (int i = 0; i < N.length(); i++)
            SUM += (N.charAt(i) - '0');

        if (N.contains("0") && SUM % 3 == 0) {
            arr = N.toCharArray();
            Arrays.sort(arr);
            for (int i = N.length() - 1; i >= 0; i--)
                sb.append(String.valueOf(arr[i]));

            System.out.println(sb.toString());
        } else System.out.println(-1);


    }
}

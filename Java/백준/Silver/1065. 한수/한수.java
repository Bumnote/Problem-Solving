import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String str;
    static char[] arr;
    static int N, cnt, diff;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        str = sc.nextLine();
        N = Integer.parseInt(str);
        if (N <= 99)
            System.out.println(N);
        else {
            cnt = 99;
            for (int i = 100; i <= N; i++) {
                arr = String.valueOf(i).toCharArray();
                flag = true;
                diff = arr[1] - arr[0];
                for (int j = 1; j < arr.length - 1; j++) {
                    if (arr[j + 1] - arr[j] != diff) {
                        flag = false;
                        break;
                    }
                }

                if (flag) cnt++;
            }

            System.out.println(cnt);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N, cnt, num;

    public static void main(String[] args) {

        N = sc.nextInt();

        cnt = 0;
        num = 1;
        while (true) {
            if (String.valueOf(num).contains("666"))
                cnt++;

            if (cnt == N)
                break;
            num++;
        }

        System.out.println(num);
    }
}

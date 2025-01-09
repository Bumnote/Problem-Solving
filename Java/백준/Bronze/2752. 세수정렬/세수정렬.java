import java.util.*;
import java.io.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int a, b, c;

    public static void main(String[] args) {

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int[] arr = {a, b, c};
        Arrays.sort(arr);

        System.out.printf("%d %d %d\n", arr[0], arr[1], arr[2]);

    }

}

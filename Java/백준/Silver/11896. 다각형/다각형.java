import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int a, b;
    static long ans = 0;

    public static void main(String[] args) {

        a = sc.nextInt();
        b = sc.nextInt();

        a = a <= 2 ? 4 : a;
        for (int n = a; n <= b; n++)
            if (n % 2 == 0)
                ans += n;

        System.out.println(ans);
    }
}

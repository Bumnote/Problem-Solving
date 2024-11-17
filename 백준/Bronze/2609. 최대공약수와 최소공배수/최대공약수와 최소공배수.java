import java.util.Scanner;

public class Main {

    private static int getGCD(int a, int b) {

        if (b == 0) return a;
        return getGCD(b, a % b);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a, b, GCD, LCM;

        a = sc.nextInt();
        b = sc.nextInt();

        GCD = getGCD(a, b);
        LCM = a * b / GCD;

        System.out.println(GCD);
        System.out.println(LCM);

    }
}
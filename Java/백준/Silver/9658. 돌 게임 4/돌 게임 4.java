import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {

        n = sc.nextInt();
        System.out.println(n % 7 == 1 || n % 7 == 3 ? "CY" : "SK");
    }
}

import java.util.*;

class Solution {

    static int N, sum = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        N = sc.nextInt();
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }

        System.out.println(sum);
    }
}
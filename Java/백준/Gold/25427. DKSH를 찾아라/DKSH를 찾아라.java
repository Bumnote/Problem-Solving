import java.util.*;
import java.io.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N, d = 0, dk = 0, dks = 0, dksh = 0;
    static char[] arr;

    public static void main(String[] args) {

        N = sc.nextInt();
        arr = sc.next().toCharArray();

        for (char c : arr) {
            if (c == 'D') d++;
            else if (c == 'K') dk += d;
            else if (c == 'S') dks += dk;
            else if (c == 'H') dksh += dks;
        }

        System.out.println(dksh);
    }
}

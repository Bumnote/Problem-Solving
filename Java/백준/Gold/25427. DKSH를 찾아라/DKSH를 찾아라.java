import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long d = 0, dk = 0, dks = 0, dksh = 0;
    static char[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        for (char c : arr) {
            if (c == 'D') d++;
            else if (c == 'K') dk += d;
            else if (c == 'S') dks += dk;
            else if (c == 'H') dksh += dks;
        }

        System.out.println(dksh);
    }
}

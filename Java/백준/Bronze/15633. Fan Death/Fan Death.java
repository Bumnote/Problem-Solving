import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = 0, n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                total += i;

        System.out.println(total * 5 - 24);
        
    }
}
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        long t, n;

        t = Long.parseLong(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());

            long k = 1L, total = 0L, layer = 0L, number;
            while (true) {
                total += k;
                layer++;
                if (total >= n)
                    break;
                k = k << 1;
            }

            number = n - ((long) (Math.pow(2, layer - 1)) - 1);

            while (layer >= 1) {
                bw.write(String.format("%d%018d", layer, number) + "\n");
                layer--;
                number = number % 2 == 0 ? number / 2 : number / 2 + 1;
            }
        }

        bw.close();
    }
}
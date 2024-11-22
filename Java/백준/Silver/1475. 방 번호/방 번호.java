import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int six_and_nine = 0, cnt, remain;
        while (n > 0) {
            remain = n % 10;
            n = (int) n / 10;

            if (remain == 6 || remain == 9)
                six_and_nine++;
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }

        cnt = six_and_nine % 2 == 0 ? (int) (six_and_nine / 2) : (int) (six_and_nine / 2) + 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (k == 6 || k == 9)
                continue;
            cnt = Math.max(cnt, v);
        }
        System.out.println(cnt);
    }
}
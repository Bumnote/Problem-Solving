import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<BigInteger> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        dp.add(new BigInteger("0"));
        dp.add(new BigInteger("1"));

        for (int i = 2; i <= n; i++)
            dp.add(dp.get(i - 2).add(dp.get(i - 1)));

        System.out.println(dp.get(n));
    }
}
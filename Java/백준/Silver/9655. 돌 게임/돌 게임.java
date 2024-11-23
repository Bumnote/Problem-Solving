import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        System.out.println(n % 2 == 1 ? "SK" : "CY");

    }
}
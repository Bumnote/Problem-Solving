import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word, str;
    static boolean flag;
    static int total;
    static Set<String> s = new HashSet<>();

    public static void main(String[] args) throws IOException {


        while (true) {
            word = br.readLine();
            if (word.equals("*"))
                break;

            flag = true;
            for (int i = 1; i < word.length(); i++) {
                total = 0;
                s.clear();
                for (int j = 0; j < word.length() - i; j++) {
                    str = String.valueOf(word.charAt(j)) + String.valueOf(word.charAt(j + i));
                    s.add(str);
                    total++;
                }

                if (s.size() != total) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                bw.write(String.format("%s is surprising.\n", word));
            else
                bw.write(String.format("%s is NOT surprising.\n", word));
        }

        bw.close();
    }
}
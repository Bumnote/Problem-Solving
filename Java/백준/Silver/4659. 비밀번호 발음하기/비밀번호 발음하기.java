import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String str;
  private static final Set<Character> aeiou = new HashSet<>();


  public static void main(String[] args) throws IOException {

    initSet();
    while (true) {
      init();
      if (str.equals("end")) {
        System.out.print(sb);
        sb.setLength(0);
        br.close();
        break;
      }
      solve();
    }
  }

  private static void init() throws IOException {
    str = br.readLine();
  }

  private static void solve() {

    boolean flag = isLeastVowel() && isSequentialWord() && isTwoSequentialWord();
    if (flag) {
      sb.append(String.format("<%s> is acceptable.", str)).append("\n");
    } else {
      sb.append(String.format("<%s> is not acceptable.", str)).append("\n");
    }
  }

  private static void initSet() {
    aeiou.add('a');
    aeiou.add('e');
    aeiou.add('i');
    aeiou.add('o');
    aeiou.add('u');
  }

  private static boolean isLeastVowel() {
    for (int i = 0; i < str.length(); i++) {
      if (aeiou.contains(str.charAt(i))) {
        return true;
      }
    }

    return false;
  }

  private static boolean isSequentialWord() {

    for (int i = 0; i <= str.length() - 3; i++) {
      int vowel = 0;
      int consonant = 0;
      for (int j = i; j < i + 3; j++) {
        if (aeiou.contains(str.charAt(j))) {
          vowel++;
        } else {
          consonant++;
        }
      }

      if (vowel == 0 || consonant == 0) {
        return false;
      }
    }

    return true;
  }

  private static boolean isTwoSequentialWord() {

    for (int i = 0; i <= str.length() - 2; i++) {
      if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) != 'e' && str.charAt(i) != 'o') {
        return false;
      }
    }
    return true;
  }
}
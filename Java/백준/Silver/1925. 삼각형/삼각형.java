import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int y1, x1, y2, x2, y3, x3;
  private static int length1, length2, length3;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    y1 = Integer.parseInt(st.nextToken());
    x1 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    y2 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    y3 = Integer.parseInt(st.nextToken());
    x3 = Integer.parseInt(st.nextToken());

    calculateLength();
    br.close();
  }

  private static void calculateLength() {
    length1 = (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
    length2 = (y3 - y2) * (y3 - y2) + (x3 - x2) * (x3 - x2);
    length3 = (y1 - y3) * (y1 - y3) + (x1 - x3) * (x1 - x3);
  }

  private static void solve() {

    if (isAllPointExistSameLine()) {
      System.out.print("X");
    } else if (isAllLineSameLength()) {
      System.out.print("JungTriangle");
    } else if (isTwoLineSameLength()) {
      if (isObtuseTriangle()) {
        System.out.print("Dunkak2Triangle");
      } else if (isAcuteTriangle()) {
        System.out.print("Yeahkak2Triangle");
      } else {
        System.out.print("Jikkak2Triangle");
      }
    } else {
      if (isObtuseTriangle()) {
        System.out.print("DunkakTriangle");
      } else if (isAcuteTriangle()) {
        System.out.print("YeahkakTriangle");
      } else {
        System.out.print("JikkakTriangle");
      }
    }
  }

  private static boolean isAllPointExistSameLine() {
    return (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1);
  }

  private static boolean isAllLineSameLength() {
    return length1 == length2 && length2 == length3;
  }

  private static boolean isTwoLineSameLength() {
    if (length1 == length2 || length2 == length3 || length3 == length1) {
      return true;
    }

    return false;
  }

  private static boolean isObtuseTriangle() {
    return length1 > length2 + length3 ||
           length2 > length1 + length3 ||
           length3 > length1 + length2;
  }

  private static boolean isAcuteTriangle() {
    return length1 < length2 + length3 &&
           length2 < length1 + length3 &&
           length3 < length1 + length2;
  }
}
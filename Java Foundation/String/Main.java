import java.util.*;

public class Main {

  public static void main(String[] args) {
    // Scanner scn = new Scanner(System.in);
    // int n = scn.nextInt();
    // System.out.println(n);
    // scn.nextLine();
    // String str = scn.nextLine();
    // System.out.println(str);
    // int a = scn.nextInt();
    // System.out.println(a);
    // scn.nextLine();
    // String str2 = scn.nextLine();
    // System.out.println(str2);

    // String s = "abcd";
    // System.out.println(s);
    // System.out.println(s.substring(0));
    // System.out.println(s.substring(2));
    // System.out.println(s.substring(2, 4));

    // char[] ch = { 'h', 'e', 'l', 'l', 'o' };
    // System.out.println(ch);

    // print all substring of the string
    // for (int i = 0; i < s.length(); i++) {
    // for (int j = i + 1; j <= s.length(); j++) {
    // System.out.println(s.substring(i, j));
    // }
    // }

    // String Builder
    StringBuilder sb = new StringBuilder("hello");
    System.out.println(sb);
    // Get character from String
    char ch = sb.charAt(0);
    System.out.println(ch);
    // Update Charater
    sb.setCharAt(0, 's');
    System.out.println(sb);
    // Inster Character in String
    sb.insert(2, 'y');
    System.out.println(sb);
    // Append Character in String
    sb.append('m');
    System.out.println(sb);
    System.out.println(sb.length());

    // Performance comparision
    int n = 100000;
    long start = System.currentTimeMillis();
    // String str = "";
    StringBuilder str = new StringBuilder("");
    // for (int i = 0; i < n; i++) {
    // str += i;
    // }
    for (int i = 0; i < n; i++) {
      str.append(i);
    }
    long end = System.currentTimeMillis();
    long time = end - start;
    System.out.println(time);

    // StringBuffer s = new StringBuffer("hello");
    StringBuilder s = new StringBuilder("hello");
    int p = s.length();
    int q = s.capacity();
    System.out.println(s);
    System.out.println("Length of string hello=" + p);
    System.out.println("Capacity of string hello=" + q);
  }
}
import java.io.*;
import java.util.*;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = getSubsequence(str);
        System.out.println(ans);
    }

    public static ArrayList<String> getSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> smallestans = new ArrayList<>();
            smallestans.add("");
            return smallestans;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1, str.length());

        ArrayList<String> withoutcharans = getSubsequence(ros);

        ArrayList<String> withcharans = new ArrayList<>();

        for (int i = 0; i < withoutcharans.size(); i++) {
            withcharans.add(withoutcharans.get(i));
        }

        for (int i = 0; i < withoutcharans.size(); i++) {
            withcharans.add(ch + withoutcharans.get(i));
        }
        return withcharans;
    }
}

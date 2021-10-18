import java.io.*;
import java.util.*;

public class GetKeyPadCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = KeyPadCombination(str);
        System.out.println(ans);
    }

    static String[] keypad = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> KeyPadCombination(String str) {
        // base case
        if (str.length() == 0) {
            ArrayList<String> smallestans = new ArrayList<>();
            smallestans.add("");
            return smallestans;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1, str.length());

        ArrayList<String> smallans = KeyPadCombination(ros);
        ArrayList<String> FinalResult = new ArrayList<>();

        String Keypadelements = keypad[ch - '0'];

        for (int i = 0; i < Keypadelements.length(); i++) {
            char temp = Keypadelements.charAt(i);

            for (int j = 0; j < smallans.size(); j++) {
                FinalResult.add(temp + smallans.get(j));
            }
        }
        return FinalResult;
    }
}

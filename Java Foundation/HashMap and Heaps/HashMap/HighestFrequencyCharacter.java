package HashMap;

import java.io.*;
import java.util.*;

public class HighestFrequencyCharacter {
    public static void printHighestFreqChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch) == true) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // Find max freq character
        char ch = ' ';
        int maxFreq = 0;
        for (char key : map.keySet()) {
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                ch = key;
            }
        }
        System.out.println(ch);
        // System.out.println(ch + " " + maxFreq);
    }

    public static void printHighestFreqChar2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        char maxfreqch = ' ';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch) == true) {
                int prevcount = map.get(ch);
                int currcount = prevcount + 1;
                map.put(ch, currcount);
            } else {
                map.put(ch, 1);
            }

            if (map.get(ch) > maxfreq) {
                maxfreq = map.get(ch);
                maxfreqch = ch;
            }
        }
        System.out.println(maxfreqch);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printHighestFreqChar(str);
    }
}

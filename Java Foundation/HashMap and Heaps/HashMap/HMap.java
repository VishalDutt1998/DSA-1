package HashMap;

import java.io.*;
import java.util.*;

public class HMap {

    public static void demo() {
        // HashMap<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        // Frequencey Map
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 1);
        map.put('d', 1);
        // System.out.println(map);
        // It overrides the d frequency corresponding to d
        map.put('d', 10);
        System.out.println(map);
        // Get return frequecy correspo
        System.out.println(map.get('a'));
        System.out.println(map.get('b'));
        System.out.println(map.get('c'));
        System.out.println(map.get('q'));

        // containsKey return true if key is Present
        boolean ans = map.containsKey('n');
        System.out.println(ans);

        // Travel in HashMap using Keys
        // Return Map Key in Random Order in a Set
        System.out.println(map.keySet());

        System.out.println("**** Keys ****");
        Set<Character> st = map.keySet();
        // Time complexity of map.keySet() is O(1) but if we fill it in array list it
        // becomes O(n)
        ArrayList<Character> keys = new ArrayList<>(map.keySet());
        for (Character key : st) {
            System.out.println(key + " " + map.get(key));
        }

        for (Character key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // Get All Value from the Hashmap
        // Returns in collection as values can be same for two or more keys
        System.out.println("**** Values ****");
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        // Remove in HashMap if exist return key otherwise return null
        System.out.println(map.remove('a'));
        System.out.println(map.remove('n'));

        //
        System.out.println("*****  Entry Set *****");
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        demo();
    }
}

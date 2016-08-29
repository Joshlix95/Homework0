/***********************************
 * Name: Josuel Musambaghani
 * HOMEWORK 0 - Software Engineering
 * ********************************* */

package problems;

import java.util.*;

public class Loops {
    /**
     * Create a map of each alphabetic character (A-Z,a-z) to its ASCII value.
     * @return the map
     *
     * A : 65
     * B : 66
     * ...
     * z : 122
     *
     * Remember that for-loops can use any primitive data type.
     */
    public static Map<Character, Integer> createAsciiMap() {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int len = alphabet.length;
        for (int i = 0; i < len; i++){
            map.put(alphabet[i],i + 65);
        }
        for (int i = 0; i < len; i++){
            map.put(Character.toLowerCase(alphabet[i]), i + 97);
        }
        return map;
    }

    /**
     * Compute the sum of a 2-dimensional array of integers
     * @param input 2-dimension array of integers
     * @return sum of all values in the array
     *
     * For example:
     * [[0 1 2 3]
     *  [4 5 6 7]]  => 28
     * [[1]
     *  [2]
     *  [3]] => 6
     */
    public static int computeSum(int[][] input) {
        if (input == null) return 0;

        int total = 0;
        for (int i = 0; i < input.length; i++){
            int sum = 0;
            for (int j = 0; j < input[i].length; j++){
                sum += input[i][j];
            }
            total += sum;
        }
        return total;
    }

    /**
     * Create a string using all of the character keys from the input map.
     * Each character should appear however many times the map suggests
     * after cycling through all of the characters in alphabetical order.
     * Input map will only contain keys a-z.
     *
     * @param characterAppearance number of times each character should appear
     * @return all of the characters in single string
     *
     * For example:
     * {a:3, b:2, c:1} => "abcaba"
     * {a:4, d:2, c:3, b:6, f:2} => "abcdfabcdfabcabbb"
     * {} => ""
     *
     * Helpful method:
     * Collections.sort(List<T> list);
     */
    public static String mapToString(Map<Character, Integer> characterAppearance) {
        if (characterAppearance == null) return "";

        String result = "";
        boolean still = true;

        while (still){
            List T = new ArrayList(characterAppearance.keySet());
            Collections.sort(T);
            still = false;
            for (int i = 0; i < T.size(); i++) {
                result += T.get(i);
                characterAppearance.put(T.get(i).toString().charAt(0), characterAppearance.get(T.get(i)) - 1);

                if (characterAppearance.get(T.get(i)) > 0)
                    still = true;
                else if (characterAppearance.get(T.get(i)) == 0)
                    characterAppearance.remove(T.get(i));
            }
        }

        return (characterAppearance == null ? "" : result);
    }
}

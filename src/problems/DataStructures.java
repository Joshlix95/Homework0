/**********************************
* Name: Josuel Musambaghani
* HOMEWORK 0 - Software Engineering
* ********************************* */

package problems;

import java.util.Arrays;

public class DataStructures {
    /**
     * Given an array of integers, return the integer that appears the most.
     * If there is a tie for most common, then return the integer that
     * appeared first in the array.
     *
     * @param input an array of integers
     * @return the integer that appeared the most
     *
     * For example:
     * [1, 2, 3, 2, 1, 4, 5] => 1
     * [6, 7, 8, 4, 5, 6, 7, 8, 9, 8] => 8
     * [] => 0
     */
    public static int mostCommon(int[] input) {
        if (input == null || input.length == 0) return 0;

        int count = 0,
                result = input[0];

        for (int i = 0; i < input.length - 1; i++){
            int elt_count = 0;

            for (int j = 0; j < input.length; j++){
                if (input[j] == input[i]){
                    elt_count++;
                }
            }

            if (elt_count > count){
                count = elt_count;
                result = input[i];
            }
        }
        return result;
    }

    /**
     * Given an array of integers, return the computation pattern
     * using as few integers as possible.
     *
     * @param input array of integers with some pattern
     * @return the shortest possible pattern as an array
     *
     * For example:
     * [1, 3, 5, 7, 9, 11] => [2]
     * [1, 3, 7, 9, 13, 15, 19] => [2, 4]
     * [6, 5, 4, 2, 1, 0, -2] => [-1, -1, -2]
     * [1, 3, 6, 8, 4, 25, 12] => [2, 3, 2, -4, 21, -13]
     *
     * Helpful method:
     * Arrays.copyOfRange(int[] arr, int from, int to)
     */
    public static int[] computeThePattern(int[] input) {
        if (input == null || input.length <= 1) return new int[0];

        boolean hasPattern = false;
        int[] temp1 = Arrays.copyOfRange(input, 1 , input.length),
                temp2 = Arrays.copyOfRange(input, 0 , input.length - 1),
                pattern = new int[input.length - 1];

        for (int i = 0; i < pattern.length; i++){
            pattern[i] = temp1[i] - temp2[i];
        }

        int middle = pattern.length % 2 != 0 ? pattern.length / 2 + 1 : pattern.length / 2;

        for (int i = 1; i < pattern.length; i++){
            int mod, count = 0;
            boolean isSubseq = true;

            int[] subseq = Arrays.copyOfRange(pattern, 0, i);

            for (int j = 0; j < pattern.length; j += i){
                int [] compare = Arrays.copyOfRange(pattern, j, j+i);
                if (!(Arrays.equals(subseq, compare))){
                    isSubseq = false;
                    break;
                }
            }

            if (isSubseq)
                return subseq;
        }

        return hasPattern ? new int[0] : pattern;
    }
}

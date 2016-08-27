package problems;

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
        /* Implement this */
        
        /* Not yet implemented */
        // - Apply quick sort  to the array 
        // - Go through the array once and count how often each element occurs
        
        /* Inefficient and less likely to work */
        int most = input[0];
        int len = input.length;
        int count = 0;
        
        for (int i = 0; i < len; i++){
            int frequency = 0;
            for (int j = 0; j < len; j++){
                if (input[j] == input[i]){
                    frequency += 1;
                }
                
                if (frequency > count){
                    count = frequency;
                    most = i;
                }
            }
        }
        
        return 0;
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
        /* Implement this */
        return new int[0];
    }
}

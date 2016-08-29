/***********************************
 * Name: Josuel Musambaghani
 * HOMEWORK 0 - Software Engineering
 * ********************************* */

package problems;

public class Strings {

    /**
     * Converts a given input string to its acronym by splitting on spaces.
     * Only alphabetical characters should be included in the acronym.
     * @param input the string to be converted
     * @return the converted string
     *
     * For example:
     * "Hello, world!" => "HW"
     * "Okay ladies now let's get in formation" => "OLNLGIF"
     * "Don't text me. Don't call me. Just leave me alone." => "DTMDCMJLMA"
     * "Give 'em the axe!" => "GETA"
     *
     * Helpful methods and classes:
     * StringTokenizer
     * Character.isLetter(char ch)
     */
    public static String toAcronym(String input) {
        /* Implement this */
        if (input == null) return "";

        input = input.replaceAll(" [^A-Za-z0-9]", " ");
        String output = "";
        String[] splitted = input.split("\\s+");

        for (int i = 0; i < splitted.length; i++){
            if (splitted[i].length() >= 1)
                output += Character.toUpperCase(splitted[i].charAt(0));
        }
        return output;
    }

    /**
     * Returns true if the input string is a palindrome.
     * A palindrome is a word, phrase, number, or other sequence of
     * characters which reads the same backward or forward.
     *
     * @param input the string to be tested
     * @return true if the string is a palindrome
     *
     * For this assignment, "A" and "a" are equals.
     * Punctuation (and other non-letter and non-digit characters) can be ignored.
     *
     * For example:
     * "Hello, world!" => false
     * "Race car" => true
     * "No 'x' in Nixon" => true
     * "An igloo! Cool, Gina!" => true
     * "1234321" => true
     *
     * Helpful method:
     * Character.isLetterOrDigit(char ch)
     */
    public static boolean isPalindrome(String input) {
        /* Implement this */
        if (input == null) return false;

        input = input.replaceAll("[^A-Za-z0-9]", "");
        int len = input.length(),
                middle = input.length() % 2 != 0 ? input.length()/2 + 1 : input.length()/2;

        if (len <= 1) return true;

        for (int i = 0; i < middle; i++){
            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(len-i-1))) return false;
        }

        return true;
    }

    /**
     * Counts the longest alphabetical substring and returns its length
     * ignoring all non-alphabetical characters. Capital vs lowercase makes no difference.
     * @param input the string to be tested
     * @return the length of the longest alphabetical string
     *
     * For example:
     * "Hello, world!" => 1
     * "Have you heard ABBA?" => 2 for "AB"
     * "I'm tired. Effort is futile." => 3 for "d. Ef" (which has only 3 letters)
     */
    public static int alphabeticalCount(String input) {
        /* Implement this */
        if (input == null) return 0;

        String alphabet = "abcdefghijklmnopqrstuvwxyz",
                input_lower = "";
        input = input.replaceAll("[^A-Za-z0-9]", "");

        for (int i = 0; i < input.length(); i++)
            input_lower += Character.toLowerCase(input.charAt(i));

        int len = input_lower.length();
        String result = "";
        String[] elts = new String[len];

        for (int i = 0; i < len ; i++){
            elts[i] = input_lower.substring(i);
        }

        for (int i = 0; i < len; i++) {
            String sub = elts[i];
            int size = elts[i].length();

            for (int j = 0; j < size; j++){
                String substr = sub.substring(0, size - j);

                if (alphabet.contains(substr) && substr.length() > result.length()){
                    result = substr;
                }
            }
        }

        return result.length();
    }
}

package j.com.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s,
 * find the length of the longest substring without repeating characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        testExpectedResult3();
        testExpectedResult1();
        testExpectedResult4();
        testExpectedResult2();
        testExpectedResult0();
    }

    public static int longestSubstringLength(String s) {
        //does not completely work,
        //because instead of clearing everything we should be clearing up till the duplicate
        //and keeping everything after to add on to a new substring
        int max = 0;
        Set<Character> charSet= new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                if (charSet.size() > max) {
                    max = charSet.size();
                }
                charSet.clear();
                charSet.add(c);
            } else {
                charSet.add(c);
            }
        }
        return max;
    }

    public static int longestSubstringLengthRefined(String s) {
        Set<Character> charSet= new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (charSet.contains(c)){
                //remove everything before c
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(c);
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    private static void testExpectedResult3() {
        logResults("abcabcbb");
    }

    private static void testExpectedResult1() {
        logResults("bbbbb");
    }

    private static void testExpectedResult4() {
        logResults("pwwkecw");
    }

    private static void testExpectedResult2() {
        logResults("abbdbc");
    }

    private static void testExpectedResult0() {
        logResults("");
    }

    private static void logResults(String s) {
        LoggerUtil.log(LongestSubstringWithoutRepeatingCharacters.class, "longestSubstringLength: " + longestSubstringLength(s)
        , "longestSubstringLengthRefined: " + longestSubstringLengthRefined(s));
    }
}

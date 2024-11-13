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
    }

    public static int longestSubstringLength(String s) {
        //does not completely work,
        //because instead of clearing everything we should be clearing up till the duplicate
        //and keeping everything after to add on to a new substring
        int max = 0;
        Set<Character> sSet= new HashSet<>();
        for (char c : s.toCharArray()) {
            if (sSet.contains(c)) {
                if (sSet.size() > max) {
                    max = sSet.size();
                }
                sSet.clear();
                sSet.add(c);
            } else {
                sSet.add(c);
            }
        }
        return max;
    }

    public static int longestSubstringLengthRefined(String s) {
        Set<Character> sSet= new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (sSet.contains(c)){
                //remove everything befire c
                sSet.remove(s.charAt(left));
                left++;
            }

            sSet.add(c);
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

    private static void logResults(String s) {
        LoggerUtil.log(LongestSubstringWithoutRepeatingCharacters.class, "longestSubstringLength: " + longestSubstringLength(s)
        , "longestSubstringLengthRefined: " + longestSubstringLengthRefined(s));
    }
}

package j.com.problems;

import java.util.*;

/**
 * Given two strings s and p,
 * return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * Anagram - a word, phrase, or name formed by rearranging the letters of another, such as spar, formed from rasp
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        testExpectedResult012();
        testExpectedResult06();
    }

    public static Object[] findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int subLength = p.length();
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        for (int i = 0; i < s.length(); i++) {
            if (i + subLength <= s.length()) {
                char[] subStringArray = s.substring(i, i + subLength).toCharArray();
                Arrays.sort(subStringArray);
                if (Arrays.equals(pCharArray, subStringArray)) {
                    indices.add(i);
                }
            }
        }
        return indices.toArray();
    }


    public static List<Integer> findAnagramsRefined(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if (s.length() < p.length()) return indices;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                indices.add(i - p.length() + 1);
            }
        }
        return indices;
    }

    private static void testExpectedResult012() {
        logResults("abab", "ba");
    }

    private static void testExpectedResult06() {
        logResults("cbaebabacd", "abc");
    }

    private static void logResults(String s, String p) {
        LoggerUtil.log(FindAllAnagramsInAString.class, "findAnagrams: " + Arrays.toString(findAnagrams(s, p))
                , "findAnagramsRefined: " + findAnagramsRefined(s, p));
    }
}

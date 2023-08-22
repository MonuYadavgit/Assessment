import java.util.*;

 
public class PalindromicSubstring {
 
    private static String findLongestPalindromicSubString(String s) {
 
        if (s == null || s.trim().length() == 0) return "";
 
        int start = 0;
        int end = 0;
 
        for (int i = 0; i < s.length(); i++) {
            int length1 = exploreFromCenter(s, i, i); // Single character in the middle.
            int length2 = exploreFromCenter(s, i, i + 1); //Two characters in the middle .
 
            int length = Math.max(length1, length2);
          
 
            if (length > end - start + 1) {
                start = i - ((length - 1) / 2);
                end = i + (length / 2);
            }
        }
        return s.substring(start, end + 1);
    }
 
    private static int exploreFromCenter(String s, int left, int right) {
 
        if (s == null || left > right)
            return 0;
 
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
 
        return right - left - 1;
    }
 
    public static void main(String[] args) {
        String answer = findLongestPalindromicSubString("madammacbookkook");
        System.out.println(answer);
    }
 
}

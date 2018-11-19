package medium._005;

/**
 * @description: Longest Palindromic Substring 最长回文子串，回文分为两种情况：aba 与 abba, 思路, 以一个字符为中心，向两侧扩展
 * @author: JJC
 * @createTime: 2018/11/19
 */
public class Palindromic {
    public String longestPalindrome(String s) {
        if  (null == s || s.length() < 1) return "";
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i+1));
            if (len > max) {
                max = len;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Palindromic().longestPalindrome(s));
    }
}

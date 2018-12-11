package easy._014;

/**
 * @description:
 * @author: JJC
 * @createTime: 2018/12/11
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestCommonPrefix = findlongestCommonPrefix(longestCommonPrefix, strs[i]);
        }
        return longestCommonPrefix;
    }
    private String findlongestCommonPrefix(String longestCommonPrefix, String next) {
        int len = Math.min(longestCommonPrefix.length(), next.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (longestCommonPrefix.charAt(i) == next.charAt(i)) {
                sb.append(longestCommonPrefix.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefixByJDK(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if(count != 0){
            prefix = strs[0];
        }
        for(int i=0; i<count; i++){
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
        String[] strings = {"dog","racecar"};
        String result = new LongestCommonPrefix().longestCommonPrefix(strings);
        System.out.println(result);
    }
}

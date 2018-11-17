package medium._003;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), maxLen = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++){
            if (charMap.containsKey(s.charAt(end))){
                start = Math.max(charMap.get(s.charAt(end)), start);
            }
            maxLen = (end - start + 1) > maxLen ? (end - start + 1) : maxLen;
            // 代表重复时，需要跳转到当前的前一位，因此存"end+1"而非end
            charMap.put(s.charAt(end), end+1);
        }
        return maxLen;
    }
}

package TwoPointers;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";

        for (String target : d) {
            if (target.length() < longestWord.length()) {
                continue;
            }
            if (target.length() == longestWord.length() && target.compareTo(longestWord) > 0) {
                continue;
            }
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    public boolean isSubStr(String s, String target) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}

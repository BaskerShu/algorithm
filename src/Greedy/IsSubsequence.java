package Greedy;

/**
 * 392. 判断子序列
 */
public class IsSubsequence {

    // 双指针1
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int sIndex = 0;
        int tIndex = 0;

        for (; tIndex < t.length(); tIndex++) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }

    // 双指针2
    public boolean isSubsequence2(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sIndex = 0, tIndex = 0;

        while (sIndex < sLen && tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex++)) {
                sIndex++;
            }
        }
        return sIndex == sLen;
    }

    // 动态规划
    public boolean isSubsequence3(String s, String t) {
        boolean table[][] = new boolean[s.length() + 1][t.length() + 1];

        for (int col = 0; col < table[0].length; col++) {
            table[0][col] = true;
        }

        for (int row = 1; row < table.length; row++) {
            char ch1 = s.charAt(row - 1);
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = t.charAt(col - 1);
                if (ch1 == ch2) {
                    table[row][col] = table[row - 1][col - 1];
                } else {
                    table[row][col] = table[row][col - 1];
                }
            }
        }

        return table[s.length()][t.length()];
    }
}

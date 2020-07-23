// 手机号查找
package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    private HashMap<String, String> letterMap = new HashMap<>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            combinations.add("");
            return combinations;
        }

        String digit = digits.substring(0, 1);
        String letters = letterMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            var nextCombinations = letterCombinations(digits.substring(1));
            if (nextCombinations.isEmpty()) {
                nextCombinations.add("");
            }
            for (String l : nextCombinations) {
                combinations.add(letters.substring(i, i+1)+l);
            }
        }
        return combinations;
    }

    // DFS
    private String[] d = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        char[] cur = new char[digits.length()];
        ArrayList<String> ans = new ArrayList<>();
        dfs(digits, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, int l, char[] cur, ArrayList<String> ans) {
        if (l == digits.length()) {
            if (l > 0) {
                ans.add(new String(cur));
            }
            return;
        }

        String s = d[Character.getNumericValue(digits.charAt(l))];
        for (int i = 0; i < s.length(); i++) {
            cur[l] = s.charAt(i);
            dfs(digits, l+1, cur, ans);
        }
    }

    // BFS
    public List<String> letterCombination3(String digits) {
        if (digits.length() == 0) return null;

        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char l : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for(String t : ans) {
                String letters = d[l - '0'];
                for (int i = 0; i < letters.length(); i++) {
                    tmp.add(t + letters.charAt(i));
                }
            }
            ans = tmp;
        }

        return ans;
    }
}

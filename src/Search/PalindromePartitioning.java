package Search;

import java.util.LinkedList;
import java.util.List;

// 131. 分割回文串
public class PalindromePartitioning {

    private boolean isPalindrome(String s, int l , int r) {

        while (r >= l) {
            if (s.charAt(r--) != s.charAt(l++)) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        List<String> curr = new LinkedList<>();
        dfs(s, 0, curr, ret);
        return ret;
    }

    private void dfs(String s, int l, List<String> curr, List<List<String>> ret) {
        if (l >= s.length()) {
            ret.add(new LinkedList<>(curr));
        }

        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                curr.add(s.substring(l, i + 1));
                dfs(s, i+1, curr, ret);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new PalindromePartitioning();
        String s = "aabb";
        var ret = obj.partition(s);

        System.out.println(ret);
    }
}

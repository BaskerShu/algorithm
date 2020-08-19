package Advanced;

/**
 * 676. 实现一个魔法字典
 *
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
class MagicDictionary {

    TrieNode trieNode;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        trieNode = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            trieNode.insert(s);
        }
    }

    public boolean search(String searchWord) {
        char[] s = searchWord.toCharArray();

        for (int i = 0; i < s.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == s[i]) continue;
                char temp = s[i];
                s[i] = c;
                if (trieNode.search(s)) return true;
                s[i] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var obj = new MagicDictionary();
        String[] dict = {"hello", "leetcode"};
        obj.buildDict(dict);
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hello"));
    }
}

class TrieNode {

    boolean isEnd;
    TrieNode[] childNodes;

    public TrieNode() {
        isEnd = false;
        childNodes = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode node = this;
        for (char c : word.toCharArray()) {
            TrieNode[] nodes = node.childNodes;
            if (nodes[c-'a'] == null) {
                nodes[c-'a'] = new TrieNode();
            }
            node = nodes[c-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(char[] word) {
        TrieNode curr = this;

        for (char c : word) {
            curr = curr.childNodes[c-'a'];
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }
}

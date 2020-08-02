package Advanced;

/**
 * 208. 实现 Trie (前缀树)
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {

    Trie[] childNodes;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        childNodes = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int wordLen = word.length();
        Trie node = this;

        for (int i = 0; i < wordLen; i++) {
            char c = word.charAt(i);

            if (node.childNodes[c-'a'] == null) {
                node.childNodes[c-'a'] = new Trie();
            }
            node = node.childNodes[c-'a'];
        }
        node.isEnd = true;
    }

    public Trie searchPrefix(String word) {
        int wordLen = word.length();
        Trie node = this;

        for (int i = 0; i < wordLen; i++) {
            char c = word.charAt(i);
            if (node.childNodes[c-'a'] == null) {
                return null;
            }
            node = node.childNodes[c-'a'];
        }

        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        String word = "hello";
        String prefix = "he";

        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
    }
}


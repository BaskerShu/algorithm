package Advanced;

import java.util.HashSet;
import java.util.List;

/**
 * 648. 单词替换
 */
public class ReplaceWords {

    // 哈希前缀
    public String replaceWords(List<String> dict, String sentence) {
        HashSet<String> rootSet = new HashSet<>(dict);

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split(" ")) {
            String prefix = "";
            for (int i = 0; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }

        return ans.toString();
    }

    // 前缀树
    public String replaceWords2(List<String> dict, String sentence) {
        StringBuilder ans = new StringBuilder();
        Trie trie = new Trie();

        for (String root : dict) {
            trie.insert(root);
        }

        for (String word : sentence.split(" ")) {
            String prefix = "";
            for (int i = 0; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (trie.search(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }

        return ans.toString();
    }
}


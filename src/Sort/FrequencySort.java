package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. 根据字符出现频率排序
 */
public class FrequencySort {
    public String frequencySort(String s) {
        if (s.isEmpty()) return "";

        HashMap<Character, Integer> charFrequency= new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry: charFrequency.entrySet()) {
            int frequencyNum = entry.getValue();
            if (bucket[frequencyNum] == null) {
                bucket[frequencyNum] = new ArrayList<>();
            }
            bucket[frequencyNum].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (char c : bucket[i]) {
                sb.append(String.valueOf(c).repeat(i));
            }
        }

        return sb.toString();
    }
}

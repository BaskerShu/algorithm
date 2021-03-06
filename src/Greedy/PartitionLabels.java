package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }
}

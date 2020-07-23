package DivideAndConquer;
/*
多数元素

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // 将 num和次数 存储到map到
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int element = 0;
        int elementNum = 0;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > elementNum) {
                element = item.getKey();
                elementNum = item.getValue();
            }
        }

        return element;
    }

    // 使用HashMap保存 num和num出现的次数
    public int solution1(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > size / 2) return num;
        }
        return -1;
    }

    // 排序
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // boyer-moore vote
    public int solution3(int[] nums) {
        return -1;
    }

    // 分治1
    public int solution4(int[] nums) {
        return majorElement(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    public int majorElement(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;
        int ml = majorElement(nums, left, mid);
        int mr = majorElement(nums, mid + 1, right);
        if (ml == mr) return ml;
        return countInRange(nums, ml, left, right) > countInRange(nums, mr, left, right) ? ml : mr;
    }

    // 分治2
    public int solution5(int[] nums) {
        return majorElementPair(nums, 0, nums.length - 1).getKey();
    }

    private SimpleEntry<Integer, Integer> majorElementPair(int[] nums, int left, int right) {
        if (left == right) return new SimpleEntry<>(nums[left], 1);

        int mid = (left + right) / 2;
        var ml = majorElementPair(nums, left, mid);
        var mr = majorElementPair(nums, mid + 1, right);
        if (ml.getKey().equals(mr.getKey())) {
            return new SimpleEntry<>(ml.getKey(), ml.getValue() + mr.getValue());
        }
        return ml.getValue() > mr.getValue() ?
                new SimpleEntry<>(ml.getKey(), ml.getValue() + countInRange(nums, ml.getKey(), mid + 1, right)) :
                new SimpleEntry<>(mr.getKey(), mr.getValue() + countInRange(nums, mr.getKey(), left, mid));
    }

    // boyer-moore
    public int solution6(int[] nums) {
        int count = 0;
        int m = nums[0];

        for (int num : nums) {
            if (num == m) {
                count++;
            }
            else {
                if (--count == 0) {
                    count = 1;
                    m = num;
                }
            }
        }
        return m;
    }
}

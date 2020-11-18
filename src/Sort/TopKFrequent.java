package Sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            values.add(new int[]{entry.getKey(), entry.getValue()});
        }

        partition(values, 0, values.size() - 1, k);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = values.get(i)[0];
        }
        return res;
    }

    private void partition(List<int[]> values, int l, int r, int k) {
        if (l >= r) return;

        int[] pivot = values.get(r);
        int i = l;
        int j = l;

        for (; i < r; i++) {
            if (values.get(i)[1] > pivot[1]) {
                swap(values, j, i);
                j++;
            }
        }
        values.set(r, values.get(j));
        values.set(j, pivot);

        if (k < j) {
            partition(values, l, j-1, k);
        }else if (k > j) {
            partition(values, j+1, r, k);
        }
    }

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> frequentNums = new HashMap<>();
        for (int num : nums) {
            frequentNums.put(num, frequentNums.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequentNums.entrySet()) {
            values.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int heapSize = values.size() - 1;
        buildMaxHeap(values, heapSize);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = values.get(0)[0];
            swap(values, 0, heapSize--);
            minHeap(values, heapSize, 0);
        }

        return res;
    }

    private void buildMaxHeap(List<int[]> values, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            minHeap(values, heapSize, i);
        }
    }

    private void minHeap(List<int[]> values, int heapSize, int index) {
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        int largest = index;

        if (l <= heapSize && values.get(l)[1] > values.get(largest)[1]) {
            largest = l;
        }
        if (r <= heapSize && values.get(r)[1] > values.get(largest)[1]) {
            largest = r;
        }

        if (index != largest) {
            swap(values, largest, index);
            minHeap(values, heapSize, largest);
        }
    }

    private void swap(List<int[]> values, int i, int j) {
        int[] temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }

public int[] topKFrequent3(int[] nums, int k) {
    // 统计每个数字出现的次数
    Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    // 一个数字最多出现 nums.length 次，因此定义一个长度为 nums.length + 1 的数组，freqList[i] 中存储出现次数为 i 的所有数字。
    List<Integer>[] freqList = new List[nums.length + 1];
    for (int i = 0; i < freqList.length; i++) {
        freqList[i] = new ArrayList<>();
    }
    counterMap.forEach((num, freq) -> {
        freqList[freq].add(num);
    });
    // 按照出现频次，从大到小遍历频次数组，构造返回结果。
    int[] res = new int[k];
    int idx = 0;
    for (int freq = freqList.length - 1; freq > 0; freq--) {
        for (int num : freqList[freq]) {
            res[idx++] = num;
            if (idx == k) {
                return res;
            }
        }
    }
    return res;
}


    public static void main(String[] args) {
        int[] nums = new int[]{5,2,5,3,5,3,1,1,3, 2};
        var obj = new TopKFrequent();
        int[] res = obj.topKFrequent2(nums, 2);

        System.out.println(Arrays.toString(res));
    }
}

package DivideAndConquer;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];

        int[] copy = new int[nums.length];
        int[] index = new int[nums.length];
        int[] tempIndex = new int[nums.length];
        for (int i =0 ;i < nums.length; i++) {
            index[i] = i;
            tempIndex[i] = i;
            copy[i] = nums[i];
            ans[i] = 0;
        }

        int l = 0;
        int r = nums.length - 1;
        mergeSort(l, r, copy, index, tempIndex, ans);

        return List.of(ans);
    }

    private void mergeSort(int l, int r, int[] copy, int[] index, int[] tempIndex, Integer[] ans) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        mergeSort(l, mid, copy, index, tempIndex, ans);
        mergeSort(mid+1, r, copy, index, tempIndex, ans);

        int p = l;
        int q = mid + 1;
        for (int i = l; i <= r; i++) {
            if (p > mid) {
                tempIndex[i] = index[q];
                q++;
            } else if (q > r) {
                tempIndex[i] = index[p];
                p++;
                ans[tempIndex[i]] += q - mid - 1;
            } else if (copy[index[p]] <= copy[index[q]]) {
                tempIndex[i] = index[p];
                p++;
                ans[tempIndex[i]] += q - mid - 1;
            } else {
                tempIndex[i] = index[q];
                q++;
            }
        }

        for (int j = l; j <= r; j++) {
            index[j] = tempIndex[j];
        }
    }

    public static void main(String[] args) {
        var obj = new CountSmaller();
        int[] nums = {1, 9, 7, 8, 5};
        var ans = obj.countSmaller(nums);
        System.out.println(ans.toString());
    }
}

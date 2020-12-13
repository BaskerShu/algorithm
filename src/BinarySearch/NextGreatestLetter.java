package BinarySearch;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        int letterLen = letters.length;

        int l = 0, h = letterLen - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;

            if (letters[mid] > target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[h] > target ? letters[h] : letters[0];
    }
}

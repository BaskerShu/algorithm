package Greedy;

import java.awt.*;

/**
 * 605. 种花问题
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return placeFlowers(flowerbed) > n;
    }

    public int placeFlowers(int[] flowerbed) {
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i - 1 < 0 || flowerbed[i - 1] == 0) {
                if (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0) {
                    if (flowerbed[i] == 0) {
                        flowerbed[i] = 1;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

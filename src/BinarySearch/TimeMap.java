package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 981. 基于时间的键值存储
 *
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
class TimeMap {

    HashMap<String, ArrayList<String>> valueMapping;
    HashMap<String, ArrayList<Integer>> tsMapping;

    public TimeMap() {
        valueMapping = new HashMap<>();
        tsMapping = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (valueMapping.containsKey(key)) {
            valueMapping.get(key).add(value);
            tsMapping.get(key).add(timestamp);
        } else {
            valueMapping.put(key, new ArrayList<>(){{add(value);}});
            tsMapping.put(key, new ArrayList<>(){{add(timestamp);}});
        }
    }

    public String get(String key, int timestamp) {
        if (!valueMapping.containsKey(key)) {
            return "";
        }
        ArrayList<String> valeList = valueMapping.get(key);
        ArrayList<Integer> tsList = tsMapping.get(key);

        if (tsList.get(0) > timestamp) {
            return "";
        }

        int l = 0;
        int r = valeList.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (tsList.get(mid) == timestamp) {
                return valeList.get(mid);
            } else if (tsList.get(mid) > timestamp) {
                r = mid - 1;
            } else if (mid == tsList.size() - 1 || tsList.get(mid + 1) > timestamp) {
                return valeList.get(mid);
            }
            else {
                l = mid + 1;
            }
        }

        return "";
    }

    public String get2(String key, int timestamp) {
        if (!valueMapping.containsKey(key)) {
            return "";
        }
        ArrayList<String> valeList = valueMapping.get(key);
        ArrayList<Integer> tsList = tsMapping.get(key);

        int l = 0;
        int r = valeList.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (tsList.get(mid) == timestamp) {
                return valeList.get(mid);
            } else if (tsList.get(mid) > timestamp) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r == -1 ? "" : valeList.get(r);
    }
}



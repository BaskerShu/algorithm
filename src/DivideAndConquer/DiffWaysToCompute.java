package DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        return way(input);
    }

    private HashMap<String, List<Integer>> map = new HashMap<>();
    private List<Integer> way(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String l = input.substring(0, i);
                String r = input.substring(i+1);

                List<Integer> lAns = way(l);
                List<Integer> RAns = way(r);

                for (int a : lAns) {
                    for (int b : RAns) {
                        switch (c) {
                            case '+':
                                ans.add(a + b);
                                break;
                            case '-':
                                ans.add(a - b);
                                break;
                            case '*':
                                ans.add(a * b);
                                break;
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(input));
        }
        map.put(input, ans);
        return map.get(input);
    }

    public static void main(String[] args) {
        var obj = new DiffWaysToCompute();
        var ans = obj.diffWaysToCompute("2-1-1");

        System.out.println(ans.toArray());
    }
}

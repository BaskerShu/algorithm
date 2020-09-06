package TwoPointers;

/**
 * 925. 长按键入
 */
public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (i <= name.length() - 1) {
            if (j >= 0 && j <= typed.length() - 1 && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j >= 1 && j <= typed.length() - 1 && name.charAt(i-1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        for (; j <= typed.length() - 1; j++) {
            if (typed.charAt(j) != name.charAt(name.length() - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var obj = new IsLongPressedName();
        boolean ans = obj.isLongPressedName("vtkgn", "vttkgnn");

        System.out.println(ans);
    }
}

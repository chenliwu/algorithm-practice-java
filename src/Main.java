import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(judge(str));
        }
    }

    public static int jumpFloor(int target) {
        jumpFloor(target, 0);
        return ans;
    }

    static int ans = 0;

    public static void jumpFloor(int target, int current) {
        if (current > target) {
            return;
        }
        if (target == current) {
            ans++;
            return;
        }
        jumpFloor(target, current + 1);
        jumpFloor(target, current + 2);
    }

    public static boolean judge(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(100));
    }

    public int sumNums(int n) {
        return n * (n + 1) / 2;
    }

}

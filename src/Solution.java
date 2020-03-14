import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return resultList;
    }

    private void helper(TreeNode root, int level) {
        if (root == null)
            return;
        if (resultList.size() == level) {
            // 初始化层次节点的存储列表
            resultList.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            // 从左右往右遍历
            resultList.get(level).add(root.val);
        } else {
            // 从右往左遍历
            resultList.get(level).add(0, root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

}

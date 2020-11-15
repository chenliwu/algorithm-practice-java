package data_structure.tree;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * @author chenlw
 * @date 2020/03/16
 */
public class 层次遍历二叉树 {

    ArrayList<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return resultList;
    }

    private void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (resultList.size() == level) {
            // 初始化level层的存储数组
            resultList.add(new ArrayList<>());
        }
        // 从左往右打印
        resultList.get(level).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }

}

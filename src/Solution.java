import sun.misc.Queue;

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

    }

    public int[] levelOrder(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            try {
                // 队头元素出队
                TreeNode node = queue.dequeue();
                nodeValues.add(node.val);
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            } catch (Exception e) {

            }

        }
        int a[] = new int[nodeValues.size()];
        int i = 0;
        for (Integer integer : nodeValues) {
            a[i++] = integer;
        }
        return a;
    }


}

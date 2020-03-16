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
        levelOrder(root, 0);
        List<Integer> list = new ArrayList<>();
        for (List<Integer> listTemp : resultList) {
            for (Integer integer : listTemp) {
                list.add(integer);
            }
        }
        int a[] = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            a[i++] = integer;
        }
        return a;
    }

    List<List<Integer>> resultList = new ArrayList<>();


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

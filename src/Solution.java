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

    boolean isSymmetrical(TreeNode pRoot) {
        List<List<Integer>> levelList = levelOrder(pRoot);

        for (List<Integer> list : levelList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : list) {
                if(integer == -1){
                    stringBuilder.append("#");
                }else{
                    stringBuilder.append(integer);
                }
            }
            if (!isDc(stringBuilder.toString())) {
                // 只要有一层不是对称的，该二叉树就不是对称二叉树
                return false;
            }
        }
        return true;
    }

    public boolean isDc(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 层次遍历二叉树，得到一个列表数组。
     *
     * @param root
     * @return
     */
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

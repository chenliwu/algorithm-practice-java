import java.util.*;


class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class Main {

    private int a;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.a);

    }

    public static void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

}

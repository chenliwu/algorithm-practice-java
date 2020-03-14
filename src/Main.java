import java.util.*;

/**
 * 二叉树定义
 */
class BinaryTree {
    public int no;
    public BinaryTree leftChild;
    public BinaryTree rightChild;
}


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int rootNo = scanner.nextInt();
            BinaryTree root = createRootNode(rootNo);
            int parentNodeNo, leftNo, rightNo;
            for (int i = 0; i < n; i++) {
                parentNodeNo = scanner.nextInt();
                leftNo = scanner.nextInt();
                rightNo = scanner.nextInt();
                createChild(root, parentNodeNo, leftNo, rightNo);
            }
            System.out.println();
            preOrderForeach(root);
            System.out.println();
            inOrderForeach(root);
            System.out.println();
            postOrderForeach(root);
        }
    }


    static BinaryTree createRootNode(int no) {
        BinaryTree root = new BinaryTree();
        root.no = no;
        return root;
    }

    static void createChild(BinaryTree root, int parenNodeNo, int leftNo, int rightNo) {
        if (root != null) {
            if (root.no == parenNodeNo) {
                if (leftNo != 0) {
                    BinaryTree leftNode = new BinaryTree();
                    leftNode.no = leftNo;
                    root.leftChild = leftNode;
                }

                if (rightNo != 0) {
                    BinaryTree rightNode = new BinaryTree();
                    rightNode.no = rightNo;
                    root.rightChild = rightNode;
                }

            } else {
                createChild(root.leftChild, parenNodeNo, leftNo, rightNo);
                createChild(root.rightChild, parenNodeNo, leftNo, rightNo);
            }
        }
    }

    /**
     * 先序遍历
     * （1）先访问根节点
     * （2）先序遍历左子树
     * （3）先序遍历右子数
     *
     * @param rootNode
     */
    static void preOrderForeach(BinaryTree rootNode) {
        if (rootNode != null) {
            // 访问根节点
            System.out.print(rootNode.no + " ");
            // 先序遍历左子树
            preOrderForeach(rootNode.leftChild);
            // 先序遍历右子树
            preOrderForeach(rootNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * （1）中序遍历左子树
     * （2）访问根节点
     * （3）中序遍历右子数
     *
     * @param rootNode
     */
    static void inOrderForeach(BinaryTree rootNode) {
        if (rootNode != null) {
            // 中序遍历左子树
            inOrderForeach(rootNode.leftChild);
            // 访问根节点
            System.out.print(rootNode.no + " ");
            // 中序遍历右子树
            inOrderForeach(rootNode.rightChild);
        }
    }

    /**
     * 后序遍历
     * （1）后序遍历左子树
     * （2）后序遍历右子数
     * （3）访问根节点
     *
     * @param rootNode
     */
    static void postOrderForeach(BinaryTree rootNode) {
        if (rootNode != null) {
            // 后序遍历左子树
            postOrderForeach(rootNode.leftChild);
            // 后序遍历右子树
            postOrderForeach(rootNode.rightChild);
            // 访问根节点
            System.out.print(rootNode.no + " ");
        }
    }


}

package data_structure.tree;


/**
 * 二叉树定义
 */
class BinaryTree {
    public Object data;
    public Object no;
    public BinaryTree leftChild;
    public BinaryTree rightChild;
}

/**
 * 二叉树练习
 *
 * @author chenlw
 * @date 2020/03/01
 */
public class BinaryTreePractice {


    public static void main(String[] args) {
        int boundaryNo = 8;
        int initNo = 1;
        // 初始化一个高度为3的二叉树
        BinaryTree rootNode = new BinaryTree();
        rootNode.data = initNo;
        rootNode.no = initNo;
        initBinaryTree(rootNode, 1, boundaryNo);

        System.out.println("");
        System.out.println("------------------------------ 先序遍历 ------------------------------");
        System.out.print("先序遍历输出编号：");
        preOrderForeach(rootNode);
        System.out.println();
        System.out.println("------------------------------ 先序遍历 ------------------------------");

        System.out.println("");
        System.out.println("------------------------------ 中序遍历 ------------------------------");
        System.out.print("中序遍历输出编号：");
        inOrderForeach(rootNode);
        System.out.println();
        System.out.println("------------------------------ 中序遍历 ------------------------------");

        System.out.println("");
        System.out.println("------------------------------ 后序遍历 ------------------------------");
        System.out.print("后序遍历输出编号：");
        postOrderForeach(rootNode);
        System.out.println();
        System.out.println("------------------------------ 后序遍历 ------------------------------");

        System.out.println("");
        System.out.println("------------------------------ 显示叶子节点 ------------------------------");
        System.out.print("显示叶子节点输出编号：");
        displayLeaf(rootNode);
        System.out.println();
        System.out.println("------------------------------ 显示叶子节点 ------------------------------");


    }

    /**
     * 递归初始化二叉树
     *
     * @param rootNode   根节点
     * @param rootNodeNo 根节点编号
     * @param boundaryNo 最大编号值 = 2^二叉树高度
     */
    public static void initBinaryTree(BinaryTree rootNode, int rootNodeNo, int boundaryNo) {
        if (rootNodeNo * 2 >= boundaryNo) {
            return;
        }
        // 左孩子节点的编号 = 父节点编号 * 2
        BinaryTree leftChild = new BinaryTree();
        leftChild.data = rootNodeNo * 2;
        leftChild.no = rootNodeNo * 2;

        // 右孩子节点的编号 = 父节点编号 * 2 +1
        BinaryTree rightChild = new BinaryTree();
        rightChild.data = rootNodeNo * 2 + 1;
        rightChild.no = rootNodeNo * 2 + 1;

        rootNode.leftChild = leftChild;
        rootNode.rightChild = rightChild;
        initBinaryTree(rootNode.leftChild, rootNodeNo * 2, boundaryNo);
        initBinaryTree(rootNode.rightChild, rootNodeNo * 2 + 1, boundaryNo);
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

    /**
     * 显示叶子节点
     *
     * @param root
     */
    static void displayLeaf(BinaryTree root) {
        if (root != null) {
            if (root.leftChild == null && root.rightChild == null) {
                System.out.print(root.data + " ");
            }
            displayLeaf(root.leftChild);
            displayLeaf(root.rightChild);
        }
    }


}

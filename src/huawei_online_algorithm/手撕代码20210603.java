package huawei_online_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chenlw 2021-06-06
 * @since 1.0.0
 */
public class 手撕代码20210603 {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        TreeNode root = new TreeNode();
        root.value = "root";
        TreeNode left = new TreeNode();
        left.value = "left";
        root.left = left;
        TreeNode right = new TreeNode();
        right.value = "right";
        root.right = right;
        preForeach(root);
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public static void preForeach(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        // 先访问左子树
        preForeach(root.left);
        // 后访问右子树
        preForeach(root.right);
    }


    static class TreeNode {
        /**
         * 树的值
         */
        public String value;

        /**
         * 左子树
         */
        public TreeNode left;

        /**
         * 右子树
         */
        public TreeNode right;
    }


    static void test2() {
        NumberResource numberResource = new NumberResource();
        new Consume(numberResource).start();
        new Product(numberResource).start();
    }

    /**
     * 共享数据
     */
    static class NumberResource {

        public List<Integer> dataList = new ArrayList<>();

        private boolean flag = true;

        public synchronized void product() {
            // 生成递增的数
            if (!flag) {
                // 未消费，等待
                try {
                    wait();
                } catch (Exception e) {

                }
            }
            flag = false;
            int num = dataList.size() + 1;
            dataList.add(num);
            System.out.println(String.format("p-{%s}-{%s}", (System.currentTimeMillis()) + " ms", num));
            // 通知消费者
            notifyAll();
        }

        public synchronized int doConsume() {
            // 存储消费
            long currentMills = System.currentTimeMillis();
            if (flag) {
                try {
                    wait();
                } catch (Exception e) {

                }
            }
            // 标记已经消费
            flag = true;
            int num = dataList.get(dataList.size() - 1);
            System.out.println(String.format("c-{%s ms} - {%s ms} - {%s}", System.currentTimeMillis(), (System.currentTimeMillis() - currentMills), num));
            // 通知需要生产
            notifyAll();
            return num;
        }

    }

    /**
     * 生产者
     */
    public static class Product extends Thread {

        private NumberResource numberResource;

        public Product(NumberResource numberResource) {
            this.numberResource = numberResource;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(10) + 1;
                try {
                    Thread.sleep(num);
                } catch (Exception e) {

                }
                numberResource.product();
            }
        }
    }

    /**
     * 消费者
     */
    public static class Consume extends Thread {

        private NumberResource numberResource;

        public Consume(NumberResource numberResource) {
            this.numberResource = numberResource;
        }

        @Override
        public void run() {
            while (true) {
                int num = numberResource.doConsume();
                if (num == 100) {
                    break;
                }
            }

        }


    }

}

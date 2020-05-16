package data_structure.list;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * @author chenlw
 * @since 2020-05-16
 */
public class 链表翻转 {

    public static void main(String[] args) {
        List<ListNode> nodeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i);
            nodeList.add(node);
        }
        for (int i = 0, len = nodeList.size(); i < len - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        ListNode head = nodeList.get(0);

        outputList(head);
        ListNode head1 = new 链表翻转().ReverseList(head);
        outputList(head1);

    }

    public static void outputList(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + "->");
            } else {
                System.out.print(head.val);
            }
            head = head.next;
        }
        System.out.println();
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        for (int i = nodeList.size() - 1; i >= 1; i--) {
            nodeList.get(i).next = nodeList.get(i - 1);
        }
        nodeList.get(0).next = null;
        head = nodeList.get(nodeList.size() - 1);
        return head;
    }

}

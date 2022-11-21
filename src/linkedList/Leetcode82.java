package linkedList;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/21 16:49
 */
public class Leetcode82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }
    }
}

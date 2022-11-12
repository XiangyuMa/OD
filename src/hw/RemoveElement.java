package hw;

public class RemoveElement {
    public static void main(String[] args) {

    }
    public static  ListNode removeElements(ListNode head, int val) {
        ListNode sentinode = new ListNode(0);
        sentinode.next = head;
        ListNode pre = sentinode,curr = head;
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }else{
                pre  = curr;
            }
            curr = curr.next;
        }
        return sentinode.next;
    }
    //两个链表相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curNode = node;
        int carry = 0;
        while (p1 != null || p2 != null){
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (p1 != null)p1 = p1.next;
            if (p2 != null)p2 = p2.next;
        }
        if (carry > 0)
            curNode.next = new ListNode(carry);

        return node.next;
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}

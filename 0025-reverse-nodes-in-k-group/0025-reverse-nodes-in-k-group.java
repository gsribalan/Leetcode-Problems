class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode temp1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp1;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftprev = dummy;
        ListNode left = head;
        while (true) {
            ListNode right = left;
            for (int i = 1; i < k && right != null; i++) {
                right = right.next;
            }
            if (right == null) {
                break;
            }
            ListNode rightnext = right.next;
            right.next = null;
            ListNode rev = reverseList(left);
            leftprev.next = rev;
            left.next = rightnext;
            leftprev = left;
            left = rightnext;
            if (left == null) {
                break;
            }
        }
        return dummy.next;
    }
}
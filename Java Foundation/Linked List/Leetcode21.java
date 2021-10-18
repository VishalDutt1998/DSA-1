// https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (one != null && two != null) {
            if (one.val < two.val) {
                temp.next = one;
                temp = temp.next;
                one = one.next;
            } else {
                temp.next = two;
                temp = temp.next;
                two = two.next;
            }
        }

        if (one == null) {
            temp.next = two;
        } else {
            temp.next = one;
        }
        return dummy.next;
    }
}
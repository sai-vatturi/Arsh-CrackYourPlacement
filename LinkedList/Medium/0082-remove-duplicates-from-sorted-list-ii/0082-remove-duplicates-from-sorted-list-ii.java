/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
        Inplace Approach TC: O(n) SC: O(1)
        ===================================
        1. Use a dummy node to handle beginning nodes having same value
        2. Use two pointers prev and current to point to dummy and head variable
        2. while the current is same to current's next keep moving the current pointer.
        3. connect prev next to current
        4. repeat until current is null and return dummy.next
    */
     public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
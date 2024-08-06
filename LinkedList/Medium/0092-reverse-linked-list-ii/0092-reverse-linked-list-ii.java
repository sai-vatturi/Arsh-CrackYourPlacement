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

    Two Pointer Method:
    ===================
    1. Use two pointers and move them to the left and before left of the linked list
    2. break the link of the first pointer and use new variable head to represent the second pointer reverse the second pointer
    3. Reverse the list until right times and then connect first pointer to current and new head to end of the current
    */ 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode current = prev.next;
        ListNode next = null;
        ListNode prevSublist = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = current.next;
            current.next = prevSublist;
            prevSublist = current;
            current = next;
        }
        
        prev.next.next = current; 
        prev.next = prevSublist;

        return dummy.next;
    }
}
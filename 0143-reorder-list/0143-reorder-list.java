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
        1. Go to the middle of the linked list and reverse the second half
        2. Now merge the two linked lists by using two pointers in-place
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow.next);
        slow.next = null; 

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        ListNode dummy = new ListNode(-1); // Temporary node to assist merging
        ListNode current = dummy;

        while (secondHalf != null) {
            current.next = firstHalf;
            firstHalf = firstHalf.next;
            current = current.next;

            current.next = secondHalf;
            secondHalf = secondHalf.next;
            current = current.next;
        }

        if (firstHalf != null) {
            current.next = firstHalf;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

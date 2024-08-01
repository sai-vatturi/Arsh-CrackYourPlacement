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
    public ListNode removeElements(ListNode head, int val) {
        // Note: In this question, there might be a case that the first element might also be the value. So, use DUMMY HEAD NODE to effectively return head after traversing
        // traverse through the linked list check whether the next element is val. if yes, remove it from the path
        // At the end, return next of dummy head

        if (head == null) {
            return null;
        } 
        if (head.next == null) {
            return head.val == val ? null : head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp != null) {
            while (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return dummyHead.next;
    }
}
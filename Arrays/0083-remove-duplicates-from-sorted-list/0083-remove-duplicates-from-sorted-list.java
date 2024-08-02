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
    public ListNode deleteDuplicates(ListNode head) {
        // Using temp node traverse the array,
        // if there exists a next, and the value of that next is same as next, then remove the chain to that.
        // At last, return the head

        // NOTE: There might be a case that there are multiple duplicates. It should remove all those duplicates

        ListNode temp = head;

        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }
}
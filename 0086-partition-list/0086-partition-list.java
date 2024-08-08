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
        Simple Approach:
        ================
        1. Take two dummy nodes lessX, greaterX and use a current variable to traverse through the list.
        2. if the node is lesser, connect it to lessX, else connect to greaterX
        3. Do this for all the nodes, at last, connect lessX with greaterX and return
    */
    public ListNode partition(ListNode head, int x) {
        ListNode lessX = new ListNode(-1);
        ListNode greaterX = new ListNode(-1);

        ListNode temp1 = lessX;
        ListNode temp2 = greaterX;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                temp1.next = current;
                temp1 = temp1.next;
            } else {
                temp2.next = current;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        temp1.next = greaterX.next;
        temp2.next = null;
        
        return lessX.next;
    }
}
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
    public int getDecimalValue(ListNode head) {

        // In a decimal linkedlist if it's like 1 -> 2 -> 3
        // we don't know 1 is in 100's place, 2 is in 10's place and 3 is in 1's place
        // so we add it to the result, and if we encounter other variable, we multiply the res with 10 and then add the number

        // similarly, in binary linkedlist, we add the number and whenever we encounter next number multiply it with 2 and then add the number

        int res = 0;
        ListNode temp = head;
        
        while (temp != null) {
            res = res * 2;
            res = res + temp.val;
            temp = temp.next;
        }

        return res;
    }
}
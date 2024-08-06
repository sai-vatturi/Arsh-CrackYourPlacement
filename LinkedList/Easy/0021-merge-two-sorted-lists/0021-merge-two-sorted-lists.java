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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy head and two temp pointers for list1 and list2
        // Check which temp pointer is smaller and add its link to the dummy head
        // traverse both the array using this merge algorithm and return dummy.next

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                current.next = temp1;
                current = current.next;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                current = current.next;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            current.next = temp1;
            current = current.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            current.next = temp2;
            current = current.next;
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}
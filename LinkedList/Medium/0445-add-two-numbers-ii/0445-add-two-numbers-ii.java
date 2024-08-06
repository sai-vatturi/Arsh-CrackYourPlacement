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
        Stack Approach:
        ===============
        1. Create two stacks add two lists to that stack
        2. remove the elements from the stack and add them creating nodes
        3. Use a carry variable to store the carry and add it to sum everytime
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (temp1 != null) {
            s1.push(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            s2.push(temp2.val);
            temp2 = temp2.next;
        }

        
        ListNode result = null;
        int sum = 0;
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum = 0;
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum = s1.pop() + s2.pop() + carry;
                carry = sum / 10;
                result = insertFront(result, sum % 10);
            }
            else {
                if (!s1.isEmpty()) {
                    sum = s1.pop() + carry;
                    carry = sum / 10;
                    result = insertFront(result, sum % 10);
                }

                if (!s2.isEmpty()) {
                    sum = s2.pop() + carry;
                    carry = sum / 10;
                    result = insertFront(result, sum % 10);
                }
            }
            
        } 

        if (carry > 0) {
            result = insertFront(result, carry);
        }

        return result;
    }

    public ListNode insertFront(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        } else {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }
    }
}
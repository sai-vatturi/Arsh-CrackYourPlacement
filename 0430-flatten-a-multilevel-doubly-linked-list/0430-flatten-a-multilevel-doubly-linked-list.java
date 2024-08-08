/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    /*
        1. Use a current node and traverse through the list
        2. if child is null, continue, else, use another pointer temp for current node's child and take it to the end of the linked list.
        3. Connct the end of the temp to current.next and current.next to current.child
        4. Repeat it until current reaches null
        Note: look at the code for clear understanding
    */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {
            if (current.child == null) {
                current = current.next;
                continue;
            }

            Node temp = current.child;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = current.next;
            if (current.next != null) {
                current.next.prev = temp;
            }

            current.next = current.child;
            current.next.prev = current;
            current.child = null;
            current = current.next;
        }

        return head;
    }
}
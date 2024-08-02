class Solution
{
    Node compute(Node head) {
        // Method 1: Use double for loop
        // Method 2:
        // Reverse the list
        // Keep max till now and remove if the element is smaller than max till now
        // update max till now at every node
        // reverse the list again
        Node reversed = reverse(head);
        
        Node dummy = new Node(-1);
        dummy.next = reversed;
        Node temp = dummy;
        int max = Integer.MIN_VALUE;
        
        while (temp != null && temp.next != null) {
            if (temp.next != null && temp.next.data < max) {
                temp.next = temp.next.next;
            } else {
                max = temp.next.data;
                temp = temp.next;
            }
        }
        
        Node output = reverse(dummy.next);
        
        return output;
        
    }
    
    Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
  
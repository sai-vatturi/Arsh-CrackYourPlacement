

// User function Template for Java

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    /*
        1. Use two dummy nodes evenHead and evenCurrent
        2. Traverse through the linked list and if it is even connect to even list and oddlist if it is odd
        3. Connect evenHead next to even current at end and return list
        
    */
    Node divide(Node head) {
        // code here
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        
        Node evenCurrent = evenHead;
        Node oddCurrent = oddHead;
        
        Node current = head;
        
        while (current != null) {
            if (current.data % 2 == 0) {
                evenCurrent.next = current;
                evenCurrent = evenCurrent.next;
            } else {
                oddCurrent.next = current;
                oddCurrent = oddCurrent.next;
            }
            current = current.next;
        }
       
        evenCurrent.next = oddHead.next;
        oddCurrent.next = null;
        
        return evenHead.next;
    }
}
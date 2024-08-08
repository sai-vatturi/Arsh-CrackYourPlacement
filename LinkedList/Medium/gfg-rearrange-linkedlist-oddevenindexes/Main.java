class Solution {
    /*
        1. Create two nodes oddIndex and evenIndex
        2. Traverse throught the list and keep adding them to oddIndex and evenIndex
        3. Finally link oddIndex and evenIndex
    */
void rearrangeEvenOdd(Node head) {
    Node oddIndex = new Node(-1);
    Node evenIndex = new Node(-1);
    
    Node oddCurrent = oddIndex;
    Node evenCurrent = evenIndex;
    
    Node current = head;
    
    while (current != null) {
        oddCurrent.next = current;
        oddCurrent = oddCurrent.next;
        current = current.next;
        
        if (current == null) {
            break;
        }
        
        evenCurrent.next = current;
        evenCurrent = evenCurrent.next;
        current = current.next;
    }
    
    oddCurrent.next = evenIndex.next;
    evenCurrent.next = null;
    
    head = oddIndex.next;
}
}

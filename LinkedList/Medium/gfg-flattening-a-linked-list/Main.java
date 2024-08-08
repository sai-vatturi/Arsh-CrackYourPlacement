import java.util.*;

class Node{
    int data;
    Node next;
    Node bottom;
    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    // Function to flatten a linked list
    /*
    Brute Force Method:
    ===================
    1. Copy all elements to a new seperate array
    2. Merge the array
    3. Create a new linked list from the array
    
    Optimized Method (Merge last two lists recursively)
    ====================================================
    1. Recursively go till last two nodes
    2. call merge function for the last two nodes and return
    3. do for all the vertical lists to get one final list
    */
    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        
        root.next = flatten(root.next);
        root = merge(root, root.next);
        
        return root;
    }
    
    Node merge(Node head1, Node head2) {
        if (head1 == null)  return head2;
        if (head2 == null)  return head1;
    
        Node dummy = new Node(-1);
        Node current = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.bottom  = head1;
                head1 = head1.bottom;
            } else {
                current.bottom = head2;
                head2 = head2.bottom;
            }
            current = current.bottom;
        }
        
        while (head1 != null) {
            current.bottom = head1;
            head1 = head1.bottom;
            current = current.bottom;
        }
        
        while (head2 != null) {
            current.bottom = head2;
            head2 = head2.bottom;
            current = current.bottom;  
        }
        
        return dummy.bottom;
    }
    
    
    // Brute Force
    // Node flatten(Node root) {
    //     // Your code here
    //     ArrayList<Integer> list = new ArrayList<>();
        
    //     while (root != null) {
    //         Node curr = root;
    //         while (curr != null) {
    //             list.add(curr.data);
    //             curr = curr.bottom;
    //         }
    //         root = root.next;
    //     }
    //     Collections.sort(list);
    //     Node resultList = new Node(0);
    //     for (int i : list) {
    //         insert(resultList, i);
    //     }
    //     return resultList.bottom;
        
    // }
    // void insert(Node head, int data) {
    //     Node newNode = new Node(data);
    //     if (head == null) {
    //         head = newNode;
    //     }
    //     else {
    //         Node temp = head;
    //         while (temp.bottom != null) {
    //             temp = temp.bottom;
    //         }
    //         temp.bottom = newNode;
    //     }
    // }

    
}

class Solution {
    class Node {
        int val;
        int frequency;
        Node next;
        
        Node(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
            this.next = null;
        }
    }

    /*  
        Hashmap And Linked
        1. Count the frequency of each element using a HashMap.
        2. Insert nodes representing elements and their frequencies into a sorted linked list.
        3. Extract the top k frequent elements from the linked list to form the result.
    */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        Node dummyHead = new Node(-1, -1);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Node newNode = new Node(entry.getKey(), entry.getValue());
            Node prev = dummyHead;
            Node curr = dummyHead.next;
            
            while (curr != null && curr.frequency > newNode.frequency) {
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr;
            prev.next = newNode;
        }
        
        int[] result = new int[k];
        Node current = dummyHead.next;
        for (int i = 0; i < k; i++) {
            result[i] = current.val;
            current = current.next;
        }
        
        return result;
    }
}
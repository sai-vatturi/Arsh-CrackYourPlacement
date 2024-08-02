class GfG
{
    /*
    1. Use a HashMap to store all the levels and increment the frequency if needed
    2. we need to stop when we reached the leaf node
    3. the condition for a node to be leaf is, both of its child should be null
    */
    void countPaths(Node root){
	// Your code here	
        Map<Integer, Integer> map = new HashMap<>();
        count(root, 1, map);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue() + " $");
        }
    }
    
    void count(Node root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            map.put(level, map.getOrDefault(level, 0) + 1);
            return;
        }
        count(root.left, level + 1, map);
        count(root.right, level + 1, map);
    }
}

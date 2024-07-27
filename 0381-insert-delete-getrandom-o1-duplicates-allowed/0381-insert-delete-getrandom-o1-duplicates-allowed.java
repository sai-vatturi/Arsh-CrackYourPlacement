class RandomizedCollection {

    // we use hashmap for O(1) retrieval and deletion but we cant get a random element from hashmap in O(1)
    // for this reason, we use an extra ArrayList because it supports indexing and O(1)
    
    private HashMap<Integer, Integer> map; // Stores the count of each element
    private ArrayList<Integer> list; // Stores the elements for random access

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean isNewElement = !map.containsKey(val);
        if (isNewElement) {
            map.put(val, 1);
        } else {
            map.put(val, map.get(val) + 1);
        }
        list.add(val); // Always add to the list
        return isNewElement;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (map.get(val) > 1) {
            map.put(val, map.get(val) - 1);
        } else {
            map.remove(val);
        }
        // Remove the element from list
        int indexToRemove = list.lastIndexOf(val);
        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
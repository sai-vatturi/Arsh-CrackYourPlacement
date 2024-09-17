class Solution {
    /*
        Hashmap Approach:
        =================
        1. Iterate through both the strings in the array
        2. Add it to the hashmap if it doesn't exist with freq 1, if it does, increase freq 
        3. Now iterate through the hashmap and add words with frequency 1 to the result string array and return
    */
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Integer> hmap = new HashMap<>();

        for (String s : s1.split(" ")) {
            hmap.put(s, hmap.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            hmap.put(s, hmap.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String,Integer> entry: hmap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        String[] resultList = new String[result.size()];
        resultList = result.toArray(resultList);

        return resultList;
    }
}
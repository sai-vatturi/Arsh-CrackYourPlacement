class TrieNode {
    TrieNode[] arr;
    boolean isEnding;

    public TrieNode() {
        this.arr = new TrieNode[26];
        this.isEnding = false;

        for (int i = 0; i < 26; i++) {
            this.arr[i] = null;
        }
    }
}

class WordDictionary {
    // Same implementation as Trie but whenever we find a wildchard character (.) for traverse through all the possible solutions at the current level. as simple as that

    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();    
    }
    
    public void addWord(String word) {
        int n = word.length();
        TrieNode curNode = this.root;

        for (int i = 0; i < n; i++) {
            int position = word.charAt(i) - 'a';
            if (curNode.arr[position] == null) {
                curNode.arr[position] = new TrieNode();
            }
            curNode = curNode.arr[position];
        }
        curNode.isEnding = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isEnding;
        }

        if (word.charAt(index) != '.') {
            int position = word.charAt(index) - 'a';
            if (node.arr[position] == null) {
                return false;
            }
            return searchHelper(word, node.arr[position], index + 1);
        }
        for (int position = 0; position < 26; position++) {
            if (node.arr[position] != null && searchHelper(word, node.arr[position], index + 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
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

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
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
        int n = word.length();
        TrieNode curNode = this.root;
        
        for (int i = 0; i < n; i++) {
            int position = word.charAt(i) - 'a';
            if (curNode.arr[position] == null) {
                return false;
            } 
            curNode = curNode.arr[position];
        }

        return curNode.isEnding;

    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode curNode = this.root;
        
        for (int i = 0; i < n; i++) {
            int position = prefix.charAt(i) - 'a';
            if (curNode.arr[position] == null) {
                return false;
            } 
            curNode = curNode.arr[position];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
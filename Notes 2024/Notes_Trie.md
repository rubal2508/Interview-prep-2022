# Trie Notes

### [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/description/) ⭐️⭐️

``` java
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsCh(ch)) curr.put(ch, new TrieNode());
            curr = curr.get(ch);
        }

        curr.isLast = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsCh(ch)) return false;
            curr = curr.get(ch);
        }
        return curr.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.containsCh(ch)) return false;
            curr = curr.get(ch);
        }
        return true;
    }

    public void delete(String word){
        root  = deleteWordRec(root, word, 0);
        return;
    }

    public TrieNode deleteWordRec(TrieNode root, String key, int i){
        if(root == null) return root;
        
        if(i==key.length()){
            root.isLast = false;
            if(root.isEmpty()) root = null;
            return root;
        }
        int ind = key.charAt(i) - 'a';
        root.children[ind] = deleteWordRec(root.children[ind],key,i+1);
        if(root.isEmpty() && root.isLast == false) root = null;
        return root;
    }
}

class TrieNode {
    public TrieNode [] children;
    public boolean isLast;

    public TrieNode() {
        children = new TrieNode[26];
        isLast = false;
    }
    
    public boolean isEmpty() {
        for(int i=0; i<26; i++){
            if(children != null) return false;
        }
        return true;
    }
    
    public boolean containsCh(char ch){
        return children[ch - 'a'] != null ;
    }

    public void put(char ch, TrieNode node){
        children[ch - 'a'] = node;
    }

    public TrieNode get(char ch){
        return children[ch - 'a'];
    }   
}
```

### [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/description/) ⭐️⭐️

- Good question, recursion is needed


### [Word Search II](https://leetcode.com/problems/word-search-ii/description/) ⭐️⭐️

- Good question again
- Build a trie for dictionary
- For each character on the board, recursively build words in all directions and see if they exist in trie. if yes then delete them from trie and add them to solution


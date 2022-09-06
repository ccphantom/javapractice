public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        int wordLength = word.length();
        for(int i = 0; i < wordLength; i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndofWord = true;

    }
    public boolean search(String word){
        int length = word.length();
        TrieNode node = root;
        for(int i = 0; i < length; i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEndofWord;

    }
    public void delete(String word){

    }
}
class TrieNode {
    int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndofWord;
    public TrieNode(){
        isEndofWord = false;
        for(int i = 0; i < ALPHABET_SIZE; i++){
            children[i] = null;
        }

    }
}

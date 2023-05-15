package hotOneHundred;

/**
 * @author fouthed
 * @date 2023/5/11
 */
public class Trie {

    private Trie[] tries;
    boolean isEnd;

    public Trie() {
        tries = new Trie[26];
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public void insert(String str) {
        Trie node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            if (node.tries[index] == null) {
                node.tries[index] = new Trie();
            }
            node = node.tries[index];
        }
        node.isEnd = true;
    }

    public boolean search(String str) {
        Trie node = prefixSearch(str);
        return node != null && node.isEnd;
    }

    public boolean startWith(String str) {
        Trie node = prefixSearch(str);
        return node != null;
    }

    public Trie prefixSearch(String str) {
        Trie node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            if (node.tries[index] == null){
                return null;
            }
            node = node.tries[index];
        }
        return node;
    }
}

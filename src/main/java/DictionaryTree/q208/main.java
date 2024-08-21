package DictionaryTree.q208;

public class main {
    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         * Trie obj = new Trie();
         * obj.insert(word);
         * boolean param_2 = obj.search(word);
         * boolean param_3 = obj.startsWith(prefix);
         */

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));      // 返回 False
        System.out.println(trie.startsWith("app"));// 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));      // 返回 True
    }
}

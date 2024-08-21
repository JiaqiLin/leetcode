package DictionaryTree.q208;

class Trie {
    private int[][] trie;
    private int cnt[];

    private int id;

    public Trie() {
        this.trie = new int[52026][26];
        this.cnt = new int[52026];
        this.id = 1;
    }

    public void insert(String word) {
        int p = 0;
        for(int i = 0;i<word.length();i++){
            int x = word.charAt(i)-'a';
            if(trie[p][x]==0){
                trie[p][x] = id;
                id++;
            }
            p = trie[p][x];
        }
        cnt[p] += 1;

    }

    public boolean search(String word) {
        int p = 0;
        for(int i = 0;i<word.length();i++){
            int x = word.charAt(i) - 'a';
            if(trie[p][x]==0) return false;
            p = trie[p][x];
        }

        return cnt[p]==0?false:true;

    }

    public boolean startsWith(String prefix) {
        int p = 0;
        for(int i = 0;i<prefix.length();i++){
            int x = prefix.charAt(i) - 'a';
            if(trie[p][x]==0) return false;
            p = trie[p][x];
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

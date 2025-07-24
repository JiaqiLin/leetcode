package array.kmp;

//0123456789  ()
class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
            if(j==n){
                return i-j;
            }
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int n = needle.length();
        int[] next = new int[n];
        int i = 1;
        int prefixLen = 0;
        while (i < n) {
            if (needle.charAt(prefixLen) == needle.charAt(i)) {
                prefixLen += 1;
                next[i] = prefixLen;
                i++;
            } else {
                if (prefixLen == 0) {
                    i++;
                } else {
                    prefixLen = next[prefixLen - 1];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(solution.strStr(haystack,needle));
    }
}

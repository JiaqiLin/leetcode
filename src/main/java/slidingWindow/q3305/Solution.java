package slidingWindow.q3305;

import java.util.Scanner;

class Solution {
    public int countOfSubstrings(String word, int k) {
        int result = 0;
        int p=0;
        //滑动窗口
        while(p<word.length()){
            int[] map = new int[26];
            int fuyin = 0;
            int q = p;
            while(q<word.length()) {
                switch (word.charAt(q)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        map[word.charAt(q) - 97] += 1;
                        break;
                    default:
                        fuyin++;
                }

                if(fuyin==k&&map['a'-97]!=0&&map['e'-97]!=0&&map['i'-97]!=0&&map['o'-97]!=0&&map['u'-97]!=0){
                    result += 1;
                }
                q++;

            }

            p++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOfSubstrings("iqeaouqi",2));
        //System.out.println(solution.countOfSubstrings("aeioqq",1));
        //iqeaou
        //qeaouq
        //eaouqi
    }
}

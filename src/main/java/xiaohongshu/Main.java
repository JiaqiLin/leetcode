package xiaohongshu;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static class Good{
        String name;
        int matchNums;
        public Good(String name, int matchNums){
            this.name = name;
            this.matchNums = matchNums;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int goodsNum = in.nextInt();
            int keysNum = in.nextInt();
            Map<String,Integer> map  = new HashMap<>();
            List<Good> result = new ArrayList<>();

            for(int i=0;i<keysNum;i++){
                map.put(in.next(),keysNum-i);
            }
            for(int i=0;i<goodsNum;i++){
                String name = in.next();
                int goodsKeyNum = in.nextInt();
                int matchNums = 0;
                int priority = 0;
                for(int j=0;j<goodsKeyNum;j++){
                    String goodsKey = in.next();
                    if(map.containsKey(goodsKey)){
                        matchNums+=1;
                        priority+=map.get(goodsKey);
                    }
                }
                result.add(new Good(name,matchNums));
            }

            Collections.sort(result,new Comparator<Good>(){
                @Override
                public int compare(Good g1,Good g2){
                    return g1.matchNums - g2.matchNums;
                    //     if (matchCompare != 0) {
                    //     return matchCompare; // 如果matchNums不同，返回比较结果
                    // } else {
                    //     // 如果matchNums相同，比较name
                    //     return g1.priority-g2.priority; // 按name升序
                    // }
                }
            });

            Collections.reverse(result);
            for(Good good:result){
                System.out.println(good.name);
            }

        }
    }
}
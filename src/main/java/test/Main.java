//package test;
//
////import java.util.Scanner;
////public class Main{
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        int n=in.nextInt();
////        in.nextLine();
////        for (int j = 0; j < n; j++) {
////            String line = in.nextLine().trim();
////            String[] words = line.split("\\s+");
////            StringBuilder sb=new StringBuilder();
////            for(String word:words){
////                sb.append(word.charAt(0));
////            }
////            System.out.println(sb.toString().toUpperCase());
////        }
////    }
////}
//
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            String a = in.next();
//            String b = in.next();
//            StringBuilder sb = new StringBuilder(a);
//            System.out.println(sb.toString());
//        }
//    }
//}
//
//
//    public static /* varargs */ void main(String ... args) {
//        ImmutableList strList = ImmutableList.of((Object)"Hollis", (Object)"\u516c\u4f17\u53f7\uff1aHollis", (Object)"\u535a\u5ba2\uff1awww.hollischuang.com");
//        strList.forEach((Consumer<String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, lambda$main$0(java.lang.String ), (Ljava/lang/String;)V)());
//    }
//
//    private static /* synthetic */ void lambda$main$0(String s) {
//        System.out.println(s);
//    }

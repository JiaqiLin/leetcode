package test;

import java.util.HashMap;

public class getTwoPow {
    public static void main(String[] args) {
        int cap = 4569;
        int n = cap - 1;
        System.out.println(getFullBinaryString(n));
        System.out.println(getFullBinaryString(n >>> 1));
        System.out.println();
        n |= n >>> 1;
        System.out.println(getFullBinaryString(n));
        System.out.println(getFullBinaryString(n >>> 2));
        System.out.println();
        n |= n >>> 2;
        System.out.println(getFullBinaryString(n));
        System.out.println(getFullBinaryString(n >>> 4));
        System.out.println();
        n |= n >>> 4;
        System.out.println(getFullBinaryString(n));
        System.out.println(getFullBinaryString(n >>> 8));
        System.out.println();
        n |= n >>> 8;
        System.out.println(getFullBinaryString(n));
        System.out.println(getFullBinaryString(n >>> 16));
        System.out.println();
        n |= n >>> 16;

        System.out.println(getFullBinaryString(n));

        int i = 0;
        System.out.println();
    }
    public static String getFullBinaryString(int num){
        String s = Integer.toBinaryString(num);
        String format = String.format("%032d", Long.parseLong(s));
        return format;
    }
}

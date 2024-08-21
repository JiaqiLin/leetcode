package test;

public class stringTest {

    public static void main(String[] args) {
        String aa = "ab"; // 放在常量池中
        String bb = new String("ab"); // 从常量池中查找
        System.out.println(aa == bb);// true
    }
}

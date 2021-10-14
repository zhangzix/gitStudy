package jiegou.zhan;

import java.util.Scanner;

/**
 * 栈的应用:分隔符匹配
 */
public class Example01 {
    private final int LEFT = 0;
    private final int RIGHT = 1;
    private final int OTHER = 2;//其他字符

    //判断分隔符的类型
    public int verifyFlag(String str) {
        if ("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)) {
            return LEFT;
        } else if (")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)) {
            return RIGHT;
        }
        return OTHER;
    }

    //检验左分隔符和右分隔符是否匹配
    public boolean matches(String s1, String s2) {
        if (
                ("(".equals(s1) && ")".equals(s2)) ||
                        ("[".equals(s1) && "]".equals(s2)) ||
                        ("{".equals(s1) && "}".equals(s2)) ||
                        ("/*".equals(s1) && "*/".equals(s2))
        ) return true;
        else
            return false;
    }

    private boolean isLegal(String str) throws Exception {
        if (!"".equals(str) && str != null) {
            SqStack sqStack = new SqStack(100);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                String t = String.valueOf(c);
                if (i != length) {
                    if (('/' == c && '*' == str.charAt(i + 1) || ('*' == c && '/' == str.charAt(i + 1)))) {
                        t = t.concat(String.valueOf(str.charAt(i + 1)));
                        i++;
                    }
                }
                if (LEFT == verifyFlag(t)) {
                    sqStack.push(t);
                } else if (RIGHT == verifyFlag(t)) {
                    if (sqStack.isEmpty() || !matches(sqStack.pop().toString(), t)) {
                        throw new Exception("Java字符匹配异常");
                    }
                }
            }
            if (!sqStack.isEmpty())
                throw new Exception("Java字符匹配异常");
            return true;
        } else {
            throw new Exception("Java语句为空");
        }
    }

    public static void main(String[] args) throws Exception {
        Example01 example01 = new Example01();
        System.out.println("请输入要匹配的字符");
        boolean flag = example01.isLegal(new Scanner(System.in).nextLine());
        if (flag) {
            System.out.println("语句合法");
        }else{
            System.out.println("语句不合法");
        }
    }
}
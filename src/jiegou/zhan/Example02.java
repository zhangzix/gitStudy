package jiegou.zhan;

/**
 * 大数加和栈应用
 */
public class Example02 {

    public LinkStack numSplit(String str, int max) throws Exception {
        LinkStack stack = new LinkStack();
        for (int i = 0; i < max; i++) {
            if (max - str.length() - i > 0) {
                stack.push(0);
            } else {
                char c = str.charAt(i - (max - str.length()));
                if (c == ' ') continue;
                else if (c > '9' || c < '0') {
                    throw new Exception("输入非法字符");
                } else {
                    stack.push(Integer.valueOf(String.valueOf(c)));
                }
            }

        }
        return stack;
    }

    public String add(String s1, String s2) throws Exception {
        LinkStack sum = new LinkStack();
        int maxSize = s1.length() > s2.length() ? s1.length() : s2.length();
        LinkStack sA = numSplit(s1, maxSize);
        LinkStack sB = numSplit(s2, maxSize);
        int partialSum = 0;
        boolean isCarry = false;
        while (!sA.isEmpty() && !sB.isEmpty()) {
            partialSum = (Integer) sA.pop() + (Integer) sB.pop();
            if (isCarry) {
                partialSum++;
                isCarry = false;
            }
            if (partialSum >= 10) {
                partialSum -= 10;
                sum.push(partialSum);
                isCarry = true;
            } else {
                sum.push(partialSum);
            }
        }
        return sum.toString();

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Example02().add("123456", "123456"));
    }

}

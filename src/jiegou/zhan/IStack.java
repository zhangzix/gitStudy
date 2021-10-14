package jiegou.zhan;

public interface IStack {
    void clear();//置空

    boolean isEmpty(); //判空

    int length();//长度

    Object peek();//取栈顶元素

    void push(Object x) throws Exception;//入栈

    Object pop();//出栈

    void display();
}

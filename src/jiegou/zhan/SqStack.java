package jiegou.zhan;

/**
 * 顺序栈
 */
public class SqStack implements IStack {
    private Object[] stackElem;
    private int top;

    public SqStack(int maxSize) {
        stackElem = new Object[maxSize];
        top = 0;
    }

    @Override
    public void clear() {
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return this.top;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return stackElem[top - 1];
        }
        return null;
    }

    @Override
    public void push(Object x) throws Exception {
        if (top == stackElem.length)
            throw new Exception("栈满");
        stackElem[top++] = x;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return stackElem[--top];
    }

    @Override
    public void display() {//打印栈顶元素到栈底元素
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stackElem[i].toString() + " ");
        }
        System.out.println();
    }
}

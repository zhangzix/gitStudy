package jiegou.duilie;

/**
 * 队列接口
 */
public interface IQueue {
    public void clear();

    public boolean isEmpty();

    public int length();

    public Object peek();

    public void offer(Object x) throws Exception;

    public Object poll();

    public void display();
}
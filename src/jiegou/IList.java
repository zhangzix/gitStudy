package jiegou;

/**
 * 线性表的8个基本操作接口
 */
public interface IList {
    public void clear();

    public boolean isEmpty();
    public int length();

    public Object get(int i);

    public void insert(int i, Object obj);

    public void remove(int i);

    public int indexOf(Object x);

    public void display();
}

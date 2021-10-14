package jiegou;

/**
 * 线性表的8个基本操作接口
 */
public interface IList {
    void clear();

    boolean isEmpty();

    int length();

    Object get(int i);

    void insert(int i, Object obj);

    void remove(int i);

    int indexOf(Object x);

    void display();
}

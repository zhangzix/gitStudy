package jiegou;

/**
 * 顺序线性表
 */
public class SqList implements IList {
    private Object[] listElem;
    private int curLen;

    public SqList(int maxSize) {
        listElem = new Object[maxSize];
        curLen = 0;
    }

    @Override
    public void clear() {
        this.curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.curLen == 0;
    }

    @Override
    public int length() {
        return this.curLen;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public void insert(int i, Object obj) {

    }

    @Override
    public void remove(int i) {

    }

    @Override
    public int indexOf(Object x) {
        return 0;
    }

    @Override
    public void display() {

    }
}

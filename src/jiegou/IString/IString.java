package jiegou.IString;

/**
 * 串接口的定义
 */
public interface IString {
    void clear();

    boolean isEmpty();

    int length();

    char charAt(int index);

    IString subString(int begin, int end);

    IString insert(int offset, IString str);

    IString delete(int begin, int end);

    IString concat(IString str);

    int compareTo(IString str);

    int indexOf(IString str, int begin);


}

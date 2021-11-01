package jiegou.IString;

import sun.applet.Main;

public class SeqString implements IString {
    private char[] strValue;//字符数组，存放串值
    private int curLen;//当前串的长度

    public SeqString() {
        strValue = new char[0];
        curLen = 0;
    }

    public SeqString(String str) {
        char[] tempchararray = str.toCharArray();
        this.strValue = tempchararray;
        curLen = tempchararray.length;
    }

    public SeqString(char[] value) {
        this.strValue = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            strValue[i] = value[i];
        }
        curLen = value.length;
    }

    @Override
    public void clear() {
        this.curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public char charAt(int index) {
        if ((index < 0) || (index > curLen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strValue[index];
    }

    @Override
    public IString subString(int begin, int end) {
        if (begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        if (end > curLen)
            throw new StringIndexOutOfBoundsException("结束位置不能大于当前串的长度:" + curLen);
        if (begin > end)
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        if (begin == 0 && end == curLen) {
            return this;
        }
        char[] buffer = new char[end - begin]; //创建一个end-begin长度的char数组
        for (int i = 0; i < buffer.length; i++) {//从i+begin索引复制数组给buffer
            buffer[i] = this.strValue[i + begin];
        }
        return new SeqString(buffer);//通过构造器返回SeqString对象
    }

    @Override
    public IString insert(int offset, IString str) {
        return null;
    }

    @Override
    public IString delete(int begin, int end) {
        if (begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        if (end > curLen)
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curLen);
        if (begin > end)
            throw new StringIndexOutOfBoundsException("起始位置不能大于结束长度");
        for (int i = 0; i < curLen - end; i++) {
            strValue[begin + i] = strValue[end + i];
        }
        curLen = curLen - (end - begin);
        return this;
    }

    @Override
    public IString concat(IString str) {
        return insert(curLen, str);
    }

    @Override
    public int compareTo(IString str) {
        return 1;
    }


//    public int compareTo(SeqString str) {

//        int len1 = curLen;
//        int len2 = str.curLen;
//        int n = Math.min(len1, len2);
//        char[] s1 = strValue;
//        char[] s2 = str.strValue;
//        int k = 0;
//        while (k < n) {
//            char ch1 = s1[k];
//            char ch2 = s2[k];
//            if (ch1 != ch2) {
//                return ch1 - ch2;
//            }
//            k++;
//        }
//        return len1 - len2;

//    }

    @Override
    public int indexOf(IString str, int begin) {
        return 0;
    }
}

package jiegou.Tree;

public class BitTreeNode {
    public Object data;
    public BitTreeNode lchild, rchild;

    public BitTreeNode(Object data, BitTreeNode lchild, BitTreeNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public BitTreeNode(Object data) {
        this(data, null, null);
    }

    public BitTreeNode() {
        this(null, null, null);
    }
}
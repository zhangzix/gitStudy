package jiegou.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 层次遍历生成二叉树
 */
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

class Tree {

    private BitTreeNode root;

    public Tree() {
        this.root = null;
    }

    public Tree(Object[] value) {
        this.root = getTree(value);
    }

    /*层次遍历生成二叉树*/
    public BitTreeNode getTree(Object[] values) {
        if (values.length == 0) {
            return new BitTreeNode();
        }
        BitTreeNode p = new BitTreeNode(values[0]);
        BitTreeNode q = p;
        Queue<BitTreeNode> queue = new LinkedList();
        int i = 0;
        while (p != null) {
            if (2 * i + 1 < values.length) {
                p.lchild = (values[2 * i + 1] != null && !"None".equals(values[2 * i + 1])) ? new BitTreeNode(values[2 * i + 1]) : null;
                if (p.lchild != null)
                    queue.add(p.lchild);
            }
            if (2 * i + 2 < values.length) {
                p.rchild = (values[2 * i + 2] != null && !"None".equals(values[2 * i + 2])) ? new BitTreeNode(values[2 * i + 2]) : null;
                if (p.rchild != null)
                    queue.add(p.rchild);
            }
            p = queue.poll();
            i += 1;
        }
        return q;
    }

    /*求树的最大深度*/
    public int getDepth(BitTreeNode T) {
        if (T != null) {
            int lDepth = getDepth(T.lchild);
            int rDepth = getDepth(T.rchild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }

    /*根节点到叶子节点的最小长度*/

    /**
     * 根节点到叶子节点的最小长度,最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 要求：使用队列实现，不可使用递归。
     *
     * @param root
     * @return
     */
    public int getSDepth(BitTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<BitTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                BitTreeNode node = queue.poll();
                if (node.lchild == null && node.rchild == null) {
                    return level;
                }
                if (node.lchild != null) {
                    queue.add(node.lchild);
                }
                if (node.rchild != null) {
                    queue.add(node.rchild);
                }
            }
        }
        return -1;
    }


    /*中序遍历*/
    public void inRootTraverse(BitTreeNode root) {
        if (root != null) {
            inRootTraverse(root.lchild);
            System.out.print(root.data + " ");
            inRootTraverse(root.rchild);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        String s="1 2 3 4 5 6 7 8 9";//测试数据
        String[] values = s.split(" ");
//        System.out.println(s);//输出测试数据
        Tree tree = new Tree(values);
//        System.out.println(tree.getDepth(tree.root));//最大深度
//        System.out.println(tree.getSDepth(tree.root));//最小深度
        tree.inRootTraverse(tree.root);
    }


}
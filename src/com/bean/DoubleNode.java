package com.bean;

/**
 * 双向循环链表
 */
public class DoubleNode {
    int data;
    DoubleNode preNode=this;
    DoubleNode nextNode=this;


    public DoubleNode(int data) {
        this.data = data;
    }
    //增加节点
    public void after(DoubleNode node){
        DoubleNode nextNext=nextNode;
        this.nextNode=node;
        node.preNode=this;
        node.nextNode=nextNext;
        nextNext.preNode=node;
//        this.preNode=node;

    }
    //获取下一个节点
    public DoubleNode getNextNode(){
        return this.nextNode;
    }
    //获取上一个节点
    public DoubleNode getPreNode(){
        return this.preNode;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "data=" + data +
                '}';
    }
}


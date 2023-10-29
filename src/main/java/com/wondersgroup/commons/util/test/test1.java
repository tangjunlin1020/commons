package com.wondersgroup.commons.util.test;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/11/11 17:05
 * @since
 */
public class test1<E extends Comparable<E>>{
    class Node{
        E value;
        Node left;
        Node right;
        int height;
        public Node(){}
        public Node(E value){
            this.value = value;
            height = 1;
            left = null;
            right = null;
        }
        public void display(){
            System.out.print(this.value + " ");
        }
    }
    Node root;
    int size;
    public int size(){
        return size;
    }
    public int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }
    //获取平衡因子(左右子树的高度差，大小为1或者0是平衡的，大小大于1不平衡)
    public int getBalanceFactor(){
        return getBalanceFactor(root);
    }
    public int getBalanceFactor(Node node){
        if(node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断一个树是否是一个平衡二叉树
    public boolean isBalance(Node node){
        if(node == null) {
            return true;
        }
        int balanceFactor = Math.abs(getBalanceFactor(node.left) - getBalanceFactor(node.right));
        if(balanceFactor > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }
    public boolean isBalance(){
        return isBalance(root);
    }

    //中序遍历树
    private  void inPrevOrder(Node root){
        if(root == null) {
            return;
        }
        inPrevOrder(root.left);
        root.display();
        inPrevOrder(root.right);
    }
    public void inPrevOrder(){
        System.out.print("中序遍历：");
        inPrevOrder(root);
    }
}


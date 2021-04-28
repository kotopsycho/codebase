package datastruct.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @package datastruct.tree
 * @Author kirain
 * @create 2021/4/16 15:08
 */
public class BinaryTree extends AbstractTree{

    //测试用
    public static TreeNode init(){
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);
        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        root.leftChild.leftChild.leftChild = new TreeNode(8);
        root.rightChild.rightChild.rightChild = new TreeNode(9);
//        TreeNode root = new TreeNode(1);
//        root.leftChild = new TreeNode(2);
//        root.leftChild.leftChild = new TreeNode(3);
//        root.leftChild.leftChild.leftChild = new TreeNode(4);
        return root;
    }

}

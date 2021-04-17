package datastruct.tree;

import java.util.Stack;

/**
 * @package datastruct.tree
 * @Author kirain
 * @create 2021/4/16 15:08
 */
public class BinaryTree {

    //访问节点
    public static void visitNode(TreeNode node){
        System.out.println(node.val);
    }

    //获取二叉树的高
    public static int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
    }

    //递归先序遍历
    public static void recursionPreorderTraversal(TreeNode node){
        if(node == null) return;
        visitNode(node);
        recursionPreorderTraversal(node.leftChild);
        recursionPreorderTraversal(node.rightChild);
    }
    //非递归先序遍历
    public static void perorderTraversal(TreeNode node){
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            visitNode(tmp);
            if(tmp.rightChild != null) stack.push(tmp.rightChild);
            if(tmp.leftChild != null) stack.push(tmp.leftChild);
        }
    }

    //递归中序遍历
    public static void recursionInorderTraversal(TreeNode node){
        if(node == null) return;
        if(node.leftChild != null) recursionInorderTraversal(node.leftChild);
        visitNode(node);
        if(node.rightChild != null) recursionInorderTraversal(node.rightChild);
    }
    //非递归中序遍历
    public static void inorderTraversal(TreeNode node){
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode p = null;
        //fixme 在弹出一次之后，检查节点时会将左孩子重新压住栈内，需要修复，可能的方式有：标记、弹出后左孩子置空（破坏了树的结构）
        while(!stack.empty()){
            while(p != stack.peek() && stack.peek().leftChild != null){
                stack.push(stack.peek().leftChild);
            }
            TreeNode tmp = stack.pop();
            p = stack.peek();
            visitNode(tmp);
            if(tmp.rightChild != null){
                stack.push(tmp.rightChild);
            }
        }
    }

}

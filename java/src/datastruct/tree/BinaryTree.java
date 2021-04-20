package datastruct.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @package datastruct.tree
 * @Author kirain
 * @create 2021/4/16 15:08
 */
public class BinaryTree {

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
    public static void preorderTraversal(TreeNode node){
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

        while(!stack.empty()){
            while(p != stack.peek() && stack.peek().leftChild != null){
                stack.push(stack.peek().leftChild);
            }
            TreeNode tmp = stack.pop();

            //标识上一访问节点，防止代码死循环，很重要的一行！
            if(!stack.empty()) p = stack.peek();

            visitNode(tmp);
            if(tmp.rightChild != null){
                stack.push(tmp.rightChild);
            }
        }
    }

    //递归后序遍历
    public static void recursionPostorderTraversal(TreeNode node){
        if(node == null) return;
        if(node.leftChild != null) recursionPostorderTraversal(node.leftChild);
        if(node.rightChild != null) recursionPostorderTraversal(node.rightChild);
        visitNode(node);
    }
    //后序非递归
    public static void postorderTraversal(TreeNode node){
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode tmp = node;
        TreeNode p = node;
        while(!stack.empty()){
            tmp = stack.peek();
            //遇到叶子节点直接出栈
            if(tmp.leftChild == null && tmp.rightChild == null){
                visitNode(stack.pop());
            }
            else{
                /*
                 * 这里要详细说明一下
                 * 栈里先压右子树再压左子树，保证栈顶往出取值是先左后右
                 * 栈每次出值都有以下几种情况
                 * 1.叶子节点
                 * 2.访问完左子树
                 * 3.访问完右子树
                 * 4.访问完根节点
                 * p初始值等于node且一直等于栈顶元素
                 * 在出栈一次以后，p值代表上次出栈元素
                 * 上次出栈元素若为自己的左右子树
                 * 则说明左右子树一定遍历完了
                 * 因为压入根节点之后再先右后左的压入子树
                 * 所以如果上次出栈的是自己的子树
                 * 自己的子树一定遍历完了
                 * 所以该遍历自己并出栈
                 * 然后更新p的值
                 */
                if(p != tmp.leftChild && p != tmp.rightChild){
                    if(tmp.rightChild != null){
                        p = tmp.rightChild;
                        stack.push(tmp.rightChild);
                    }
                    if(tmp.leftChild != null){
                        p = tmp.leftChild;
                        stack.push(tmp.leftChild);
                    }
                }else{
                    p = stack.pop();
                    visitNode(p);
                }
            }
        }
    }

    //层序遍历
    public static void levelTraversal(TreeNode node){
        if(node == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode tmp;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            visitNode(tmp);
            if(tmp.leftChild != null) queue.offer(tmp.leftChild);
            if(tmp.rightChild != null) queue.offer(tmp.rightChild);
        }
    }

}

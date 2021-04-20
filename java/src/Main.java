import datastruct.tree.BinaryTree;
import datastruct.tree.TreeNode;

/**
 * @package dataset
 * @Author Kiran
 * @create 2021/4/20 0:18
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.init();
        //BinaryTree.postorderTraversal(root);
        BinaryTree.levelTraversal(root);
    }
}

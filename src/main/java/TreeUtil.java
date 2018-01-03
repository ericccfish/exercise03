/**
 * Created by chenjianfeng on 2017/9/24.
 */
public class TreeUtil {
    public static void preOrderTraversal(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void InOrderTraversal(TreeNode root){
        if(root!=null){
            InOrderTraversal(root.left);
            System.out.print(root.val+" ");
            InOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(TreeNode root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val+" ");
        }
    }
}

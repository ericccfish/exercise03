/**
 * Created by chenjianfeng on 2017/9/24.
 */
class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x){this.val = x;}
}
public class BinarySearchTree {
    public TreeNode insertNode(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val)
            root.left = insertNode(root.left, val);
        else
            root.right = insertNode(root.right, val);
        return root;
    }

    public TreeNode randomCreatBST(int[] arr){
        if(arr.length==0)
            return null;
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1; i<arr.length; i++)
            insertNode(root, arr[i]);
        return root;
    }

    public TreeNode balanceCreatBST(int[] arr, int left, int right){
        if(left>right)
            return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = balanceCreatBST(arr, left, mid-1);
        root.right = balanceCreatBST(arr, mid+1, right);
        return root;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = new int[]{3,1,2,5,0,7,9,8};
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode unbalance = bst.randomCreatBST(arr);
        TreeUtil.preOrderTraversal(unbalance);
        System.out.println();
        int[] arr2 = new int[]{0,1,2,3,5,7,8,9};
        TreeNode balance = bst.balanceCreatBST(arr2, 0, arr2.length-1);
        TreeUtil.preOrderTraversal(balance);
        System.out.println();
    }
}

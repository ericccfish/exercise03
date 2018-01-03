/**
 * Created by chenjianfeng on 2017/12/6.
 */
public class Exercise {
    public int exPartition(int[] arr, int left, int right){
        if(left>=right)
            return left;
        int pivot = arr[left];
        while(left<right){
            while(right>left && arr[right]>=pivot)
                right--;
            if(right>left && arr[right]<pivot){
                arr[left] = arr[right];
                left++;
            }
            while(left<right && arr[left]<=pivot)
                left++;
            if(left<right && arr[left]>pivot){
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        return left;
    }
    public void exQuickSort(int[] arr, int left, int right){
        if(left>=right)
            return ;
        int k = exPartition(arr, left, right);
        exQuickSort(arr, left, k-1);
        exQuickSort(arr, k+1, right);
    }
    public TreeNode exBalanceCreatTree(int[] arr, int left, int right){
        if(left>right)
            return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = exBalanceCreatTree(arr, left, mid-1);
        root.right = exBalanceCreatTree(arr, mid+1, right);
        return root;
    }
    public static void main(String[] args) throws Exception{
        int[] arr = {5,3,7,9,1,8,10};
        Exercise ex = new Exercise();
        ex.exQuickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
            if(i==arr.length-1)
                System.out.println();
        }
        TreeNode root = ex.exBalanceCreatTree(arr, 0, arr.length-1);
        TreeUtil.preOrderTraversal(root);
        System.out.println();
    }
}

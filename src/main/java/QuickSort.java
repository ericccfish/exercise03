/**
 * Created by chenjianfeng on 2017/9/24.
 */
public class QuickSort {
    public int partition(int[] arr, int left, int right){
        if(left>=right)
            return left;
        int pivot = arr[left];
        while(left<right){
            while(left<right && arr[right]>=pivot)
                right--;
            if(left<right) {
                arr[left] = arr[right];
                left++;
            }
            while(left<right && arr[left]<=pivot)
                left++;
            if(left<right){
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        return left;
    }

    public void quickSort(int[] arr, int left, int right){
        if(left>=right)
            return;
        int k = partition(arr, left, right);
        quickSort(arr, left, k-1);
        quickSort(arr, k+1, right);
    }

    public static void main(String[] args) throws Exception{
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{9,10,11,13,7,8,12};
        qs.quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        return;
    }
}

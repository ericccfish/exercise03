/**
 * Created by chenjianfeng on 2017/9/24.
 */
public class BinSearch {
    public boolean binSearch(int[] arr, int left, int right, int target){
        if(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target)
                return true;
            else if(arr[mid]<target)
                return binSearch(arr, mid+1, right, target);
            else
                return binSearch(arr, left, mid-1, target);
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = new int[]{1,3,4,6,8,11,12,15};
        BinSearch bs = new BinSearch();
        System.out.println(bs.binSearch(arr, 0, arr.length-1, 11));
    }
}

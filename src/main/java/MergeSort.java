/**
 * Created by chenjianfeng on 2017/9/24.
 */
public class MergeSort {
    public int[] merge(int[] a, int[] b){
        if(a.length==0 || b.length==0)
            return a.length==0? b:a;
        int res[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        for(int k=0; k<a.length+b.length; k++){
            if(i>=a.length)
                res[k] = b[j++];
            else if(j>=b.length)
                res[k] = a[i++];
            else {
                if (a[i] < b[j])
                    res[k] = a[i++];
                else
                    res[k] = b[j++];
            }
        }
        return res;
    }

    public int[] mergeSort(int[] arr, int left, int right){
        if(left>=right)
            return new int[]{arr[left]};
        int mid = (left + right) / 2;
        int[] lArr = mergeSort(arr, left, mid);
        int[] rArr = mergeSort(arr, mid + 1, right);
        return merge(lArr, rArr);
    }

    public static void main(String[] args) throws Exception{
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{9,10,11,13,7,8,12};
        int[] res = ms.mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<res.length; i++)
            System.out.print(res[i]+" ");

    }
}

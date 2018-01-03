/**
 * Created by chenjianfeng on 2017/9/24.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null || l2==null)
            return l1==null? l2:l1;
        if(l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) throws Exception{
        int[] arr1 = new int[]{1,3,5,7,9};
        ListNode l1 = new ListNode(arr1[0]);
        ListNode pNode = l1;
        for(int i=1; i<arr1.length; i++){
            pNode.next = new ListNode(arr1[i]);
            pNode = pNode.next;
        }
        int[] arr2 = new int[]{2,4,6,8,10};
        ListNode l2 = new ListNode(arr2[0]);
        pNode = l2;
        for(int i=1; i<arr2.length; i++){
            pNode.next = new ListNode(arr2[i]);
            pNode = pNode.next;
        }
        MergeTwoLists mtl = new MergeTwoLists();
        ListNode head = mtl.mergeTwoLists(l1, l2);
        pNode = head;
        while(pNode!=null){
            System.out.print(pNode.val+" ");
            pNode = pNode.next;
        }
    }
}

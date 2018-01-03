/**
 * Created by chenjianfeng on 2017/9/24.
 */
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int x){this.val = x;}
}

public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head==null)
            return head;
        ListNode pNode = head;
        ListNode pPrev = null;
        ListNode pNext = null;
        while(pNode!=null){
            pNext = pNode.next;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pPrev;
    }

    public ListNode reverseList(ListNode head, boolean useRecur){
        if(head==null || head.next==null)
            return head;
        ListNode pNode = reverseList(head.next, useRecur);
        head.next.next = head;
        head.next = null;
        return pNode;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr[0]);
        ListNode pNode = head;
        for(int i=1; i<arr.length; i++){
            pNode.next = new ListNode(arr[i]);
            pNode = pNode.next;
        }
        ReverseList rl = new ReverseList();
        pNode = head;
        while(pNode!=null){
            System.out.print(pNode.val+" ");
            pNode = pNode.next;
        }
        System.out.println();
        pNode = rl.reverseList(head, true);
        while(pNode!=null){
            System.out.print(pNode.val+" ");
            pNode = pNode.next;
        }
    }
}

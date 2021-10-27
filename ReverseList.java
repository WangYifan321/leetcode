//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseList {
    static class ListNode {
     int val;
     ListNode next;

     ListNode() {
     }

     ListNode(int val) {
      this.val = val;
     }

     ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
     }
    }
    public static ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
         return head;
        }else {
         ListNode newHead;
         newHead = reverseList(head.next);
         head.next.next=head;
         head.next=null;
         return newHead;
        }
    }

    public static ListNode reverseList2(ListNode head){
        ListNode newHead = new ListNode(0,null);

        while(head!=null){
         ListNode tmp = head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=tmp;
        }
        return newHead.next;

    }
}

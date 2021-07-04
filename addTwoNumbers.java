
//https://leetcode-cn.com/problems/add-two-numbers/
public class addTwoNumbers {

     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tail=null,head=null;
            int carry = 0;
            while(l1!=null || l2!=null){
                int x = (l1 == null) ? 0 : l1.val;
                int y = (l2 == null) ? 0 : l2.val;
                int sum = x + y + carry;
                if(tail == null){
                    head = tail = new ListNode(sum % 10);
                }else{
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }

            }
            if(carry > 0){
                tail.next = new ListNode(carry);
                tail = tail.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {

    }
}

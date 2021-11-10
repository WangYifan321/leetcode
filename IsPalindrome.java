import java.util.ArrayList;
import java.util.List;
//https://leetcode-cn.com/problems/palindrome-linked-list/
public class IsPalindrome {

      static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public static boolean isPalindrome(ListNode head){
          List<Integer> list = new ArrayList<>();
          ListNode node=head;
          while(node!=null){
              list.add(node.val);
              node=node.next;
          }
          ListNode newHead = new ListNode(0,null);
          while(head!=null){
              node=head.next;
              head.next=newHead.next;
              newHead.next=head;
              head=node;
          }
          node=newHead.next;
          for(int num:list){
              if(num!=node.val){
                  return false;
              }
              node=node.next;
          }
          return true;
      }

      //解法二，反转链表的后半部分，然后变成两个链表，比较。最后恢复链表
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
        //快慢指针，快指针一次走两个，慢指针一次走一个。快指针到末尾时慢指针走到中间
        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }


}

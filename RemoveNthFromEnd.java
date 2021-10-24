import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {
//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

     static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    static class Solution {
         //求链表的长度，减去倒数的个数n，正着向后便利
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode result;
            if(head.next==null){
                return null;
            }else{
                int flag=0;
                result=head;
                while(head!=null){
                    flag++;
                    head=head.next;
                }
                if(flag==n){
                    result=result.next;
                    return result;
                }
                head=result;
                int a=flag-n-1;
                while(a>0){
                    a--;
                    head=head.next;
                }
                head.next=head.next.next;
                return result;

            }

        }
    }

    static class Solution2{//借助栈一次便利实现
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Deque<ListNode> stack=new LinkedList<>();
            ListNode h=new ListNode(0,head);//给头节点前面再弄一个节点，使头节点与后面的节点有相同的处理方式
            stack.push(h);
            while(head!=null){
                stack.push(head);
                head=head.next;
            }
            for(int i=0;i<n;i++){
                stack.pop();
            }
            ListNode node = stack.peek();
            node.next=node.next.next;
            return h.next;
        }

    }
    //第三种解法：双指针。弄一个快指针，一个慢指针，让快指针先往后走n个，快慢指针之间有n-1个节点，在头节点之前弄一个哑节点，当快指针到最后指向null时，哑节点的下一个就是要删除的节点
    //第四种解法：递归。走出递归的条件是head!=null。递归完回溯时，弄一个标记位，达到倒数第n个时返回。

}

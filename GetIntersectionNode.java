import java.util.List;
//得到两个链表相交的节点
//相交的是节点对象，而不是节点的值https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class GetIntersectionNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        if (headA==null || headB==null) {
            return null;
        }
        while(pa!=pb){//最多也就循环m+n次，
            pa = pa==null ? headB : pa.next;
            pb = pb==null ? headA : pb.next;
        }
        return pa;
    }
}

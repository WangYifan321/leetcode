public class mergeTwoSortedLists {
    //https://leetcode-cn.com/problems/merge-two-sorted-lists/
    //递归解法
    class Solution {
        public addTwoNumbers.ListNode mergeTwoLists(addTwoNumbers.ListNode l1, addTwoNumbers.ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    //非递归解法

        class Solution2 {
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                ListNode result = new ListNode();
                ListNode flag = result;
                while(l1!=null && l2!=null){
                    if(l1.val < l2.val){
                        result.next = l1;
                        result = result.next;
                        l1 = l1.next;
                    }else{
                        result.next = l2;
                        result = result.next;
                        l2 = l2.next;
                    }
                }
                if(l1 != null){
                    result.next = l1;
                }
                if(l2 != null){
                    result.next = l2;
                }
                return flag.next;
            }

    }

}

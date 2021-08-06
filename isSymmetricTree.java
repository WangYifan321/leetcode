import java.util.LinkedList;
import java.util.Queue;
/*
判断对称二叉树，递归解法https://leetcode-cn.com/problems/symmetric-tree/
class Solution {
    public boolean isSymmetric(TreeNode root) {
      return check(root.left,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q==null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
 */
public class isSymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p,TreeNode q){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while(!queue.isEmpty()){
                TreeNode m = queue.poll();
                TreeNode n = queue.poll();
                if(m == null && n == null){
                    continue;
                }
                if(m == null || n == null || m.val != n.val){
                    return false;
                }
                queue.offer(m.left);
                queue.offer(n.right);
                queue.offer(m.right);
                queue.offer(n.left);
            }
            return true;
        }

    }
}


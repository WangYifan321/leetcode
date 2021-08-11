import java.util.LinkedList;
import java.util.Queue;

public class maxDepthOfBinarytree {
    public class TreeNode {
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
    class solution1{
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }else{
                int left = maxDepth(root.left);
                int right = maxDepth(root.right);
                return Math.max(left,right)+1;
            }
        }
    }
    class solution2{
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }else{
                Queue<TreeNode> queue = new LinkedList<>();
                int ans=0;
                queue.offer(root);
                while(!queue.isEmpty()){
                    int flag = queue.size();
                    while(flag != 0){
                        TreeNode tree = queue.poll();
                        if(tree.left!=null)
                        queue.offer(tree.left);
                        if(tree.right!=null)
                        queue.offer(tree.right);
                        flag--;

                    }
                    ans++;
                }
                return ans;
            }
        }
    }
}

public class InvertTree {
//https://leetcode-cn.com/problems/invert-binary-tree/
    //递归，把一个树的反转分解为子问题
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

      public TreeNode invertTree(TreeNode root){
          if(root!=null){
              TreeNode tmp;
              tmp=root.left;
              root.left=root.right;
              root.right=tmp;
              invertTree(root.left);
              invertTree(root.right);
          }

          return root;
      }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}

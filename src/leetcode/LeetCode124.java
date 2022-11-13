package leetcode;

public class LeetCode124 {

        int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return res;
        }
        public int dfs(TreeNode root){
            if(root == null) return 0;
            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));
            res = Math.max(res, root.val + left + right);
            return root.val + Math.max(left, right);
        }


       class TreeNode {
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
}

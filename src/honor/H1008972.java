package honor;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2024/5/10 13:23
 */
public class H1008972 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t1Root = scanner.nextInt();
        TreeNode root1 = null;
        for(int i = 0;i < n;i++){
            int fa = scanner.nextInt();
            int lch = scanner.nextInt();
            TreeNode lchNode = new TreeNode(lch);
            int rch = scanner.nextInt();
            TreeNode rchNode = new TreeNode(rch);
            TreeNode faNode = new TreeNode(fa);
            faNode.left = lchNode;
            faNode.right = rchNode;
            root1 = custructTree(root1,faNode);
        }

        int m = scanner.nextInt();
        int t2Root = scanner.nextInt();
        TreeNode root2 = null;
        for(int i = 0;i < m;i++){
            int fa = scanner.nextInt();
            int lch = scanner.nextInt();
            TreeNode lchNode = new TreeNode(lch);
            int rch = scanner.nextInt();
            TreeNode rchNode = new TreeNode(rch);
            TreeNode faNode = new TreeNode(fa);
            faNode.left = lchNode;
            faNode.right = rchNode;
            root2 = custructTree(root2,faNode);
        }
        System.out.println(isSameTree(root1,root2));
        scanner.close();
    }
    public static boolean isSameTree(TreeNode t1,TreeNode t2){
        if(t1.val != t2.val) {
            return false;
        }
        if(t1.val == t2.val){
            isSameTree(t1.left,t2.left);
            isSameTree(t1.right,t2.right);
        }
        return true;
    }
    public static TreeNode custructTree(TreeNode root,TreeNode newNode){
        if(root == null && newNode != null){
            root = newNode;
        }
        if(root.left.val == newNode.val){
            root.left = newNode;
        }
        if(root.right.val == newNode.val){
            root.right = newNode;
        }
        if(root.val != newNode.val){
            custructTree(root.left,newNode);
            custructTree(root.right,newNode);
        }
        return root;
    }
   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public  TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val,TreeNode left,TreeNode right){
            this.left = left;
            this.right = right;
            this.val = val;
        }

       public void setLeft(TreeNode left) {
           this.left = left;
       }

       public void setRight(TreeNode right) {
           this.right = right;
       }

       public void setVal(int val) {
           this.val = val;
       }

   }
}

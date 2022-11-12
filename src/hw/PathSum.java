package hw;

/**
 * Description:
 *
 * @author maxiangyu
 * @date Created on 2020/5/24-22:06
 */
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
// Related Topics 树 深度优先搜索

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 递归实现
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum){
        if(null == root){
            return false;
        }
        sum -= root.val;
        if(root.left == null &&root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
    //还可以利用迭代的方法去实现
}

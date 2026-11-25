/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) 
    {
      List<Integer> Result = new ArrayList<>();
      inorder(root,Result);
      return Result;  
    }
    public void inorder(TreeNode Node,List<Integer>result)
    {
        if(Node==null)
        {
            return;
        }
        inorder(Node.left,result);
        result.add(Node.val);
        inorder(Node.right,result);
    }
}
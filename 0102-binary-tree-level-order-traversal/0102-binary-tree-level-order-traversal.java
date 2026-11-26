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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> Result = new ArrayList<>();
         if(root==null)
        {
            return Result;

        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
            TreeNode Node=q.remove();
            level.add(Node.val);
                if(Node.left!=null)
               {
                q.add(Node.left);
               }
               if(Node.right!=null)
               {
                q.add(Node.right);
               }

            }
            Result.add(level);
            
        }
    return Result;   
  }
}
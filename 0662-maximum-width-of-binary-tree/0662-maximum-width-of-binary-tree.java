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
    public int widthOfBinaryTree(TreeNode root) 
    {
       class pair
     {
        TreeNode node;
        long num;
       
       pair(TreeNode node,long num)
       {
        this.node=node;
        this.num=num;
       }
     }

       Queue<pair> q = new LinkedList<>();
       q.add(new pair(root,0));

       int maxwidth=0;

       while(!q.isEmpty())
       {
        int size=q.size();
        long minIndex=q.peek().num;
        long first=0,last=0;
        for(int i=0;i<size;i++)
        {
            pair curr=q.remove();
            long currIndex=curr.num-minIndex;

            if(i ==0) 
            {
                first=currIndex;
            }
            if(i==size-1) 
            {
                last=currIndex;
            }

            if(curr.node.left != null)
            {
                q.add(new pair(curr.node.left,(2*currIndex)+1));
            }
            
            if(curr.node.right != null)
            {
                q.add(new pair(curr.node.right,(2*currIndex)+2));
            }
            maxwidth=Math.max(maxwidth,(int)(last-first+1));

        }
       }
       
       return maxwidth;
    }
}
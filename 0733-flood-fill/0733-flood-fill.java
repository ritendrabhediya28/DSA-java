class Solution 
{
    public void replace(int sr,int sc,int color,int[][] image,int n,int m,int originalcolor)
    {
       if(sr < 0 || sr >= n || sc < 0 || sc >= m)
      {
        return;
      }
        if(originalcolor!=image[sr][sc])
        {
            return;
        }
            image[sr][sc]=color;
            replace(sr,sc-1,color,image,n,m,originalcolor); // left
            replace(sr,sc+1,color,image,n,m,originalcolor); // right
            replace(sr-1,sc,color,image,n,m,originalcolor); // up
            replace(sr+1,sc,color,image,n,m,originalcolor);// down

        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int n=image.length;
        int m=image[0].length;
        int originalcolor=image[sr][sc];

        if(originalcolor == color)
        {
            return image;
        }
        replace(sr,sc,color,image,n , m,originalcolor);
        return image;
        
    }
}
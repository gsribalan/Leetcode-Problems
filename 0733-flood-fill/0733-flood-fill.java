class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean [][] visited=new boolean[image.length][image[0].length];
        dfs(sr,sc,image,visited,color,image[sr][sc]);
        return image;
    }
    public void dfs(int row,int col,int [][] image,boolean [][] visited,int color,int org){
        if(row<0 || row>=image.length || col<0 || col>=image[0].length)return;
        if(image[row][col]!=org)return;
        if(visited[row][col])return;
        visited[row][col]=true;
        image[row][col]=color;
        dfs(row+1,col,image,visited,color,org);
        dfs(row-1,col,image,visited,color,org);
        dfs(row,col+1,image,visited,color,org);
        dfs(row,col-1,image,visited,color,org);        
    }
}
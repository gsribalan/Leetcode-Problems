class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.offer(new int[] {i,j});
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int mins=-1;
        int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int levelElements=q.size();
            while(levelElements-- > 0){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int d=0;d<4;d++){
                    int newr=r+direction[d][0];
                    int newc=c+direction[d][1];
                    if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]==1){
                        grid[newr][newc]=2;
                        fresh--;
                        q.offer(new int[]{newr,newc});
                    }
                }
            }
            mins++;
        }
         if(fresh>0) return -1;
         else return mins;
        
    }
}
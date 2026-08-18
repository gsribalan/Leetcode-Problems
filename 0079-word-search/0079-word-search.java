class Solution {
    public boolean recur(char[][] board,String word,int r,int c,boolean[][] visited,int k){
        if(k==word.length())return true;
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c] || board[r][c]!=word.charAt(k))return false;

        visited[r][c]=true;
        //recursive call
        if(recur(board,word,r+1,c,visited,k+1) ||
        recur(board,word,r,c+1,visited,k+1)||
        recur(board,word,r-1,c,visited,k+1)||
        recur(board,word,r,c-1,visited,k+1))return true;
        visited[r][c]=false;

        return false;

    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited =new boolean[board.length][board[0].length];
        boolean result=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    result=recur(board,word,i,j,visited,0);
                    if(result)return true;
                }
            }
        }
        return false;
    }
}
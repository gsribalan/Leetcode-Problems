class Solution {
    public void recur(int open,int close,int n,String s,List<String>res){
        if(open==n && close==n){
            res.add(s);
            return;
        }
        if(open<n)recur(open+1,close,n,s+"(",res);
        if(open>close)recur(open,close+1,n,s+")",res);
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        recur(0,0,n,"",res);
        return res;
    }
}
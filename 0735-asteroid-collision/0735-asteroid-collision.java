class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>steriod=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                int n=Math.abs(asteroids[i]);
                while(!steriod.isEmpty() && steriod.peek()>0 &&steriod.peek() <=n ){
                        if(steriod.peek()==n){
                            steriod.pop();
                            n=0;
                            break;
                        }
                        else{
                            steriod.pop();
                        }
                }
                if(n>0 && (steriod.isEmpty() || steriod.peek()<0)){
                    steriod.push(asteroids[i]);
                }
            }
            else{
                steriod.push(asteroids[i]);
            }            
        }
        int [] res=new int[steriod.size()];
        for(int i=steriod.size()-1;i>=0;i--){
            res[i]=steriod.pop();
        }
        return res;
    }
}
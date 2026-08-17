class Solution {
    List<List<Integer>>s;
    List<Integer>ans=new ArrayList<>();
    public void sub(int n,int[]nums){
        if(n==nums.length){
            s.add(new ArrayList<>(ans));
            //System.out.println(s);
            return;
        }
         ans.add(nums[n]);
        sub(n+1,nums);
        ans.remove(ans.size()-1);
        sub(n+1,nums);
       
    }
    public List<List<Integer>> subsets(int[] nums) {
        s=new ArrayList<>();
        sub(0,nums);
        return s;
    }
}
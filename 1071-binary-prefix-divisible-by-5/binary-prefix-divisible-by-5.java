class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list=new ArrayList<>();
        int a=0;
        for(int i=0;i<nums.length;i++){
             a=(a*2+nums[i])%5;
             if(a%5==0){
                list.add(true);
             }
             else{
                list.add(false);
             }
        }
        return list;
    }
}
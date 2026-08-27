class Solution {
    public int findLUSlength(String a, String b) {
        if(a.length()<b.length()){
            return b.length();
        }
         
        if(!b.contains(a)){
            return a.length();
        }
        
        return -1;
        
        
         
    }
}
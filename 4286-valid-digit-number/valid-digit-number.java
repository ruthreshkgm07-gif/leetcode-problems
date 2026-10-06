class Solution {
    public boolean validDigit(int n, int x) {
        boolean answer = false;
        int digit = 0;
        while(n>0){
            digit = n%10;
            n = n/10;
            if(digit == x)
                answer = true;
        }
        if(digit == x)
            answer = false;
        return answer;
    }
}
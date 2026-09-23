class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
     String se="";
     for(char c:stack){
        se+=c;
     }
     return se;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        HashMap map = new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(map.get(stack.pop()).equals(c)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

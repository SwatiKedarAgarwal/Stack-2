// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return result;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                prevTime = curTime;
            } else {
                result[stack.pop()] += curTime - prevTime + 1;
                prevTime = curTime + 1;
            }
        }

        return result;
    }
}

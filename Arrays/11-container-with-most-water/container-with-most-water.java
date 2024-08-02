class Solution {
    public int maxArea(int[] height) {

        // Brute: check for maxArea between two walls by double for loops
        // Optimal: Use left and right pointers
        // 1. select the min of left and right and multiply it with length (right - left) to get area
        // 2. keep track of maxArea
        // 3. we want to eliminate the shorted one because we are greedy for more water. so move the pointer with shorter height and return max sum

        int sum = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);

            sum = Math.max(sum, area);
            if (height[left] < height[right]) {
                left ++;
            }
            else {
                right--;
            }
        }

        return sum;
    }
}
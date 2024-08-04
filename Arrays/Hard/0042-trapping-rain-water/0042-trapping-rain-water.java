class Solution {
    public int trap(int[] height) {
        // optimal approach:
        // Idea: max water that can be hold at any point in the array is min(maxLeft, maxRight) - a[i]
        // Two pointer at left and right along with leftMax and rightMax
        // By the above idea, add min(left, right) to the existing sum, and keep on iterating till left <= right and return sum

        int left = 0;
        int right = height.length - 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax -  height[right];
                }
                right--;
            }
        }

        return water;
    }
}
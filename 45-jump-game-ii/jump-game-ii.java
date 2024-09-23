class Solution {
    /*
        BFS + Greedy Approach:
        =======================
        1. At each index, calculate the farthest point that can be reached.
        2. Increment the jump count (ans) when reaching the end of the current jump range.
        3. Stop when the farthest point is beyond or at the last index of the array.
    */
  public int jump(int[] nums) {
    int ans = 0;
    int end = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; ++i) {
      farthest = Math.max(farthest, i + nums[i]);
      if (farthest >= nums.length - 1) {
        ++ans;
        break;
      }
      if (i >= end) {   
        ans++;        
        end = farthest; 
      }
    }

    return ans;
  }
}
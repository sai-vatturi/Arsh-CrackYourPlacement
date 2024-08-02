class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // The question asks that what is the maximum sum if we take continous elements from left and righit
        // assume this like a maximum sum of a circular subarray where we shouldnt pick elements from the middle
        // approach:
        // the maximum sum of the subarray will be equal to the total sum - (sum of sliding window of size n - k)
        // see code to understand more

        int totalSum = 0;
        for (int i : cardPoints) {
            totalSum += i;
        }
        int n = cardPoints.length;
        int windowSize = n - k;
        int slidingSum = 0;
        for (int i = 0; i < windowSize; i++) {
            slidingSum += cardPoints[i];
        }
        int minSlidingSum = slidingSum;
        for (int i = 0, j = windowSize; j < n; i++, j++) {
            slidingSum += cardPoints[j] - cardPoints[i];
            minSlidingSum = Math.min(minSlidingSum, slidingSum);
        }

        return totalSum - minSlidingSum;
    }
}
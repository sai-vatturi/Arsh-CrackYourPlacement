
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        long minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < a.size() - m + 1; i++) {
            minDiff = Math.min(minDiff, a.get(i + m - 1) - a.get(i));
        }
        return minDiff;
    }
}
class Solution {
    /*
        Brute force solution:
        =====================
        1. Create a resultant array of size n + 1
        2. Iterate through all the numbers and get no od 1s in the binary representation
        3. Return resultant array
    */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            result[i] = bin(i);
        }

        return result;  
    }

    public int bin(int i) {
        int ans = 0;
        
        while (i > 0) {
            if (i % 2 == 1)
                ans++;
            i /= 2;
        }
        return ans;
    }
}
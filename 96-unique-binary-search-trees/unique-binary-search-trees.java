class Solution {
    /*
        Example: (Let's solve this by taking an example of 4 nodes)

        numTrees(4) = numTree(0) * numTree(3)
                      numTree(1) * numTree(2)
                      numTree(2) * numTree(2)
                      numTree(3) * numTree(1)
    */
    public int numTrees(int n) {
        int[] sol = new int[n + 1];
        sol[0] = sol[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sol[i] += sol[i - j] * sol[j - 1];
            }
        }

        return sol[n];
    }
}
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // The idea is to two take two variables and return their multiplicatoin
        // Answer will be very large
        // Hence, use MOD wherever you find see overflow might occur
        long MOD = 1000000007;
        
        long firstVal = 0;
        long secondVal = 0;
        
        while (first != null) {
            firstVal = (firstVal * 10) % MOD;
            firstVal = (firstVal + first.data % MOD);
            first = first.next;
        }
        
        while (second != null) {
            secondVal = (secondVal * 10) % MOD;
            secondVal = (secondVal + second.data % MOD);
            second = second.next;;
        }
        
        return (firstVal % MOD * secondVal % MOD) % MOD;
        
    }
}
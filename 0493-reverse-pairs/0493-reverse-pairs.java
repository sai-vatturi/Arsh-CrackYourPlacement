class Solution {
    // This is similar to count inversions questions
    /*
    // The idea is to use merge sort to count the number of inverse pairs at the time of merge method.
    // we will return the count as mid - i + 1 because When merging, if you encounter an element in the right half (arr[j]) that is smaller than an element in the left half (arr[i]), it means that all remaining elements in the left half from index i to mid will form inversions with arr[j]. This is because the left half is sorted, so every element from arr[i] to arr[mid] is greater than arr[j].
    */
    // here what's different is, instead of incrementing count at the time of merging using two pointers, we initially check for the whole array for inverse pairs.
    // this step is used because the condition varies from before question to this question
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    } 
    
    int mergeSort(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }
    
    int merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int count = 0;
        int i = start, j = mid + 1, k = 0;
        
        // Count the reverse pairs
        for (i = start; i <= mid; i++) {
            while (j <= end && arr[i] > 2 * (long)arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        // Reset pointers for merge process
        i = start;
        j = mid + 1;
        
        // Merge step
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        
        for (int idx = 0; idx < temp.length; idx++) {
            arr[start + idx] = temp[idx];
        }
        
        return count;
    }
}
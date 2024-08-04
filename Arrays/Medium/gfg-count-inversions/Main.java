
class Solution {
    
    // The idea is to use merge sort to count the number of inverse
    // pairs at the time of merge method.
    
    // we will return the count as mid - i + 1 because
    // When merging, if you encounter an element in the right half (arr[j]) that is smaller than an element in the left half (arr[i]), it means that all remaining elements in the left half from index i to mid will form inversions with arr[j]. This is because the left half is sorted, so every element from arr[i] to arr[mid] is greater than arr[j].
    static long inversionCount(long arr[], int n) {
        long count = mergeSort(arr, 0, n - 1);
        return count;
    } 
    
    static long mergeSort(long[] arr, int start, int end) {
        long count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }
    
    static long merge(long[] arr, int start, int mid, int end) {
        long[] ans = new long[end - start + 1];
        long count = 0;
        
        int i = start;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                ans[k++] = arr[i++];
            }
            else {
                ans[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            ans[k++] = arr[i++];
        }
        while (j <= end) {
            ans[k++] = arr[j++];
        }
        
        for (int idx = 0; idx < ans.length; idx++) {
            arr[start + idx] = ans[idx];
        }
        
        return count;
    }
}

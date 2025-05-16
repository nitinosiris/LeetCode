public class MaxSubArray {
    /*
        Given an array of size N, find the maximum length of non-decreasing subarray:
        [0 7 3 10 2 4 6 8 0 9 -20 4]
        ans = 4, [2 4 6 8]
     */

    public int maxSubArray(int[] arr)
    {
        int n = arr.length;
        if (n == 0)
            return 0;

        int ans = 1;
        int length = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            ans = Math.max(ans, length);
        }

        return ans;
    }

    public int maxSubArrayWithUpdate(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            int usedUpdate = 0;
            int length = 1;
            int prev = arr[i];

            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= prev) {
                    length++;
                    prev = arr[j];
                } else if (usedUpdate == 0) {
                    // Use the one update: pretend arr[j] == prev
                    usedUpdate = 1;
                    length++;
                    // prev remains the same
                } else {
                    // Already used update, and current value is decreasing → break
                    break;
                }
            }

            maxLen = Math.max(maxLen, length);
        }

        return maxLen;
    }
}

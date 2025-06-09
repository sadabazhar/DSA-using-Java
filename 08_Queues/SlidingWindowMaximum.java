public class SlidingWindowMaximum {

    //Brute-force Approach
    public int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;

        //Store all maximum value of each windows
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {

            int max = Integer.MIN_VALUE;

            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }

            result[i] = max;
        }
        
        return result;
    }
}

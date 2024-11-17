class FindMissingEle {

    // 1st Approach (Using sum formula)
    public static int findMissing1(int[] arr) {
        int n = arr.length + 1;  // Since one element is missing, total should be n + 1
        
        // Correct sum of numbers from 0 to n-1
        int totalSum = n * (n - 1) / 2;
        
        // Calculate sum of all array elements
        int eleSum = 0;
        for (int num : arr) {
            eleSum += num;
        }
        
        // The missing number is the difference between the expected sum and the actual sum
        return totalSum - eleSum;
    }

    // 2nd Approach (Using XOR)
    public static int findMissing2(int[] arr) {
        int n = arr.length + 1;  // Since one element is missing, total numbers are n + 1

        // XOR all array elements
        int xorArray = 0;
        for (int num : arr) {
            xorArray ^= num;
        }
        
        // XOR all numbers from 0 to n-1 (complete range)
        int xorFull = 0;
        for (int i = 0; i < n; i++) {
            xorFull ^= i;
        }

        // XOR of xorArray and xorFull gives the missing number
        return xorArray ^ xorFull;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5};

        // Test first approach
        int missing1 = findMissing1(arr);
        System.out.println("Missing element (Approach 1 - Sum) is: " + missing1);
        
        // Test second approach
        int missing2 = findMissing2(arr);
        System.out.println("Missing element (Approach 2 - XOR) is: " + missing2);
    }
}

class MinMax{

    public static int[] minMax(int[] arr) {

        // Edge Case: Check if the array is null or empty
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    
        // Initialize min and max with extreme values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    
        for (int elem : arr) {
            if (elem < min) {
                min = elem;  // Update min if current element is smaller
            }
            if (elem > max) {
                max = elem;  // Update max if current element is larger
            }
        }
    
        return new int[]{min, max};
    }    

    public static void main(String[] args){
        int[] arr = new int[]{100, -2, 30, 44, -2, 100};
        int[] result = minMax(arr);
        System.out.println("Minimum number: " + result[0]);
        System.out.println("Maximum number: " + result[1]);
    }

}
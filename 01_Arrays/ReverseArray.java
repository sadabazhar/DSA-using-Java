/*
 * I/p: 12,23,131,34,0,15
 * O/p: 15 0 34 131 23 12
 */

class ReverseArray{

    public static int[] reverseArray(int[] arr) {

        // Edge case: Check if array is null or empty
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null");
        }
    
        int start = 0;
        int end = arr.length - 1;
    
        // Swap elements until the middle is reached
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            //Update start and end
            start++;
            end--;         
        }
    
        // Return the reversed array
        return arr;
    }
    

    public static void main(String[] args){

        int[] arr = new int[] {12,23,131,34,0,15};
        int[] Result = reverseArray(arr);
        
        System.out.println("Reversed Array: ");
        for(int num : Result){
            System.out.print(num + " ");
        }
    }
}
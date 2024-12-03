/*
I/P ->{2, 3, 5, 12, 65, 54}, K=2
O/P -> {65, 54, 2, 3, 5, 12}
*/

class RotateArray{


    //brute force approach
    public static int[] rotateArray1(int arr[], int kth) {
        int size = arr.length;

        //Edge case
        if (kth < 0 || kth >= size) {
            throw new IllegalArgumentException("kth must be between 0 and size of array");
        } else {
            // Create a temporary array with size kth
            int[] temp = new int[kth];
    
            // Copy the last kth elements to temp
            for (int i = size - kth; i < size; i++) {
                temp[i - (size - kth)] = arr[i];
            }
    
            // Shift the remaining elements to the end
            for (int i = size - 1; i >= kth; i--) {
                arr[i] = arr[i - kth];
            }
    
            // Copy the temp elements back to the beginning
            for (int i = 0; i < kth; i++) {
                arr[i] = temp[i];
            }
    
            // Return the rotated array
            return arr;
        }
    }
    

    //Modulo approach
    public static int[] rotateArray2(int[] arr, int kth) {

        int size = arr.length;
        int[] temp = new int[size];
    
        // Edge case
        if (kth < 0 || kth >= size) {
            throw new IllegalArgumentException("kth must be between 0 and size of array");
        } else {

            for (int i = 0; i < size; i++) {

                // Calculate new index for rotation
                int newI = (i + kth) % size;

                // Place the element in the new index
                temp[newI] = arr[i];
            }


            // Return the rotated array
            return temp;
        }
    }
    
    
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 12, 23, 32};
        int[] shiftedArray = rotateArray2(arr, 2);
    
        for (int ele : shiftedArray) {
            System.out.print(ele + " ");
        }
    }
}  
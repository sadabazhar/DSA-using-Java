// Find common elements in three sorted arrays
/*
 * {1, 5, 10, 20, 40, 80}
 * {6, 7, 20, 80, 100}
 * {3, 4, 15, 20, 30, 70, 80, 120}
 
  * Output{20, 80}
*/

public class CommonEle3Sorted {
    static void find1(int[] arr1, int[] arr2, int[] arr3){
        // Using 3 loops

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                for(int k=0; k<arr3.length; k++){
                    if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                        System.out.print(arr1[i] + " ");
                    }
                }
            }
        }

        /* 
        *   Avoid this solution bcz it's O(n^3)
        */
    }

    static void find2(int[] arr1, int[] arr2, int[] arr3) {
        // We know arrays are sorted therefore,

        int i = 0, j = 0, k = 0;
    
        // Loop until one of the pointers exceeds the length of these arrays
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
    
            // if element is arr1[i] smaller than arr2[j], means target could be ahead of arr1[i]
            if (arr1[i] < arr2[j]) {
                i++;
            }
            // if element is arr2[j] smaller than arr3[k], means target could be ahead of arr2[j]
            else if (arr2[j] < arr3[k]) {
                j++;
            }
            // Otherwise, target could be ahead of arr3[k]
            else {
                k++;
            }
    
            // Check if elements in all three arrays are the same
            if (i < arr1.length && j < arr2.length && k < arr3.length && arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                // Print the common element
                System.out.print(arr1[i] + " ");

                //Move to the next for other common elements
                i++; j++; k++;
            }
        }
    }
    

    public static void main(String[] args){
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        find2(arr1, arr2, arr3);
    }
}

/*
 * Rotate the 2D array 90% in place (means no extra space)
 * I/p:
     arr = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
        }
 * O/p:
     arr = {
        {7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}
        }
 */

public class RotateImage {
    
    public static void rotate(int[][] arr) {

        //Step 1: Transpose the array

        for(int raw = 0; raw < arr.length; raw++) {
            
            // col = raw+1 reduce extra computation (Do not swap it self)
            for(int col = raw+1; col < arr[raw].length; col++) {
                int temp = arr[raw][col];
                arr[raw][col] = arr[col][raw];
                arr[col][raw] = temp;
            }
        }

        // Step 2: Reverse each row in the 2D array

        for (int row = 0; row < arr.length; row++) {
            int start = 0;
            int end = arr[row].length - 1;
            
            while (start < end) {
                
                int temp = arr[row][start];
                arr[row][start] = arr[row][end];
                arr[row][end] = temp;
                
                start++;
                end--;
            }
        }


        //Print Rotated 2D array

        for(int row=0 ; row < arr.length ; row++){
            for(int col=0 ; col < arr[row].length ; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }   
    
    public static void main(String[] args) {
        int[][] arr = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                    };
        
        rotate(arr);
    }
}

import java.util.*;

public class Basic2D_Op {
    public static void setData(int [][] arr, int raw, int col){
        Scanner In = new Scanner(System.in);
        System.out.println("Enter elements: ");

        for(int i=0; i<raw; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = In.nextInt();
            }   
        }
        In.close();
    }

    public static void getData(int [][] arr, int raw, int col){
        System.out.println("All elementss: ");
        for(int i=0; i<raw; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(int [][] arr, int raw, int col) {
        System.out.println("Transpose of matrix: ");
        
        // Outer loop to iterate over rows
        for(int i = 0; i < raw; i++) {
            
            // Inner loop to iterate over columns starting from i+1 to avoid double swap
            for(int j = i + 1; j < col; j++) {
                
                // Swapping elements arr[i][j] and arr[j][i]
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    



    public static void main(String[] args){
        int[][] arr = new int[3][3];

        setData(arr, 3, 3);
        getData(arr, 3, 3);
        transpose(arr, 3, 3);
        getData(arr, 3, 3);
    }
}
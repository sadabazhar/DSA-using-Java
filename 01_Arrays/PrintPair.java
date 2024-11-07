/*
* Example : I/P -> [1,2,3] 
O/P -> [1,1],[1,2],[1,3] [2,1],[2,2],[2,3] [3,1],[3,2],[3,3]
*/

class PrintPair{

    public static void printPair(int[] arr){

        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array must not be null");
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                // Print each pair arr[i], arr[j]
                System.out.println(arr[i]+","+arr[j]);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3};
        printPair(arr);
    }
}
/*
 * I/P => 2, 1, 10, 5, 1, 10, 2
 * O/P => 5
*/

class FindUnique{

    public static int findUnique(int[] arr){
        int ans=0;
        for(int i=0; i<arr.length; i++){
            // XOR operation cancels out elements that appear twice
            ans = ans ^ arr[i];
        }

        return ans;
    }


    public static void main(String[] args){
        int[] arr = {2, 1, 10, 5, 1, 10, 2};
        int unique = findUnique(arr);
        System.out.println("The unique number is: " + unique);
    }
}
public class SaperateNegPos {

    public static void separateNegativePositive(int[] arr) {
        int neg = 0;
        int pos = arr.length - 1;
    
        while (neg < pos) {
            // Increment neg pointer if the current element is negative
            if (arr[neg] < 0) {
                neg++;
            }
            // Decrement pos pointer if the current element is positive
            if (arr[pos] > 0) {
                pos--;
            }
            
            // Swap elements if neg is positive and pos is negative
            if (neg < pos) {
                int temp = arr[neg];
                arr[neg] = arr[pos];
                arr[pos] = temp;
            }
        }
    }
    

    public static void main(String[] args){
        int[] arr = {-2, 5, 3, 8, -1, 9, -4};

        separateNegativePositive(arr);

        for( int elee : arr){
            System.out.print(elee+" ");
        }
    }
}

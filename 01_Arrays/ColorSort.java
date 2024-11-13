/*
 * I/p: {0, 1, 0, 2 , 1, 2, 1, 2}
 * O/p: {0, 0, 1, 1, 1, 2, 2, 2}
 */

public class ColorSort {

    public static void sortColors1(int[] nums) {

        // solve using count methode

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                green++;
            } else {
                blue++;
            }
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i = red; i < red + green; i++) {
            nums[i] = 1;
        }

        for (int i = red + green; i < red + green + blue; i++) {
            nums[i] = 2;
        }
    }

    public static void sortColors2(int[] nums) {
        // solve using two pointers

        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while(i<right) {
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
                left++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                // no need to increase val of index
                right--;
            }else{
                i++;
            }
        }
        
    }

    public static void main(String[] args){
        int[] arr = new int[] {0, 1, 0, 2 , 1, 2, 1, 2};
        sortColors2(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}

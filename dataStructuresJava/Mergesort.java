package dataStructuresJava;


/**
 * Merge Sort!
 * Divide and conquer algorithm that takes the input array, splits it in the middle 
 * recursively until 1 element remains and then merges the subarrays in order
 */

public class Mergesort {

    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    /* I use this helper method to make the call more compatible with 
       an array read froma file or whatever so that you dont need to have all 4
       parameters in the function call */

    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;
        
            int mid = (leftStart + rightEnd) / 2;

            /* recursive calls for each half of the array */

            mergeSort(array, temp, leftStart, mid);
            mergeSort(array, temp, mid + 1, rightEnd);
            merge(array, temp, leftStart, rightEnd);
    }

    public static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] < array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size); 
    }

    public static void main(String[] args) {
        int[] nums = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        mergeSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}

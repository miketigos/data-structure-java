package dataStructuresJava;

/*
implementation of quicksort algorithm for sorting integers low to high
Author: Michael Thomas
*/

public class Quicksort {

    public static void quicksort(int[] array, int low, int high) {

        if (low < high) {

            /* 
            pi is the partitioning index at which we 
            will split the array for divide and conquer
            */

            int pi = getPartitionIndex(array, low, high);

            /* recursive calls for quicksort */
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    public static int getPartitionIndex(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;
        int temp;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        temp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp;

        return i + 1;
    }

    /* Driver code for quicksort test */
    public static void main(String[] args) {

        int[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        quicksort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

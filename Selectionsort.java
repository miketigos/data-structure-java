package dataStructuresJava;


public class Selectionsort {
    
    public static void selectionSort(int[] array) {
        int minIndex;
        int len = array.length;

        for (int i = 0; i < len; i++) {
            minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                } 
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;    
            }
        }
    }
    
    /* driver code for selection sort */
    public static void main(String[] args) {
        int[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        selectionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

package algorithms.sorting;
import util.*;
//https://www.youtube.com/watch?v=COk73cpQbFQ
//select the min element by scanning the array
//swap the min with the leftmost.


public class QuickSort {
    public static void main(String[] args) {
        int a[] = {5, 10, 3, 9};
        quickSort(a);
       GenericUtil.printArray(a);
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int partitionIndex = getPartitionIndex(a, low, high, a[low + high] / 2);
        quickSort(a, 0, partitionIndex - 1);
        quickSort(a, partitionIndex + 1, high);
    }

    private static int getPartitionIndex(int[] a, int low, int high, int pivotValue) {

        int left = 1;
        int right = high;

        while (left < right) {
            while (a[left] <= pivotValue)
                left++;
            while (a[right] >= pivotValue)
                right--;
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left--;
                right++;
            }
        }
        return left;
    }

}

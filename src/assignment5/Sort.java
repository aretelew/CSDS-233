package assignment5;

import java.util.*;

public class Sort {
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

            printArray(array);
        }
    }

    public void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortHelper(array, left, middle);
            mergeSortHelper(array, middle + 1, right);
            merge(array, left, middle, right);

            printArray(array);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(array, left, leftArray, 0, leftSize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightSize);

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            printArray(array);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public void bucketSort(int[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int numBuckets = (maxValue - minValue) / bucketSize + 1;

        List<Integer>[] buckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : array) {
            int bucketIndex = (value - minValue) / bucketSize;
            buckets[bucketIndex].add(value);
        }

        printBuckets(buckets);

        int currentIndex = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            Collections.sort(bucket, Collections.reverseOrder());
            for (int value : bucket) {
                array[currentIndex++] = value;
            }
        }

        System.out.println("\nAfter sorting in descending order:");
        printArray(array);
    }

    private static void printBuckets(List<Integer>[] buckets) {
        System.out.println("Buckets after distribution:");
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket " + i + ": " + buckets[i]);
        }
    }

    private void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}

/*
Insertion Sort performs the most swaps and comparisons, which makes it inefficient for larger amounts of data.
Merge Sort on average has fewer comparisons than Insertion Sort, but it involves more array accesses, as it recursively splits the problem into more smaller problems.
Quick Sort usually has fewer comparisons and swaps compared to Insertion Sort, especially when the pivot is chosen correctly. In the worst case however, its performance can be worse.
Bucket Sort, when the data is uniform, has fewer comparisons and relatively efficient sorting, but its performance depends on the distribution of the data and the bucket sizing.
Overall, Quick Sort is the most efficient and performs well for most cases, which makes it the most efficient out of the bunch.
*/

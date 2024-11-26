package assignment5;

public class TestClass {
    public static void main(String[] args) {
        Sort sorter = new Sort();
        int[] testArray = {26, 13, 72, 3, 17, 37, 0, 17, 73, 45};

        System.out.println("Insertion Sort:");
        sorter.insertionSort(testArray.clone());

        System.out.println("\nMerge Sort:");
        sorter.mergeSort(testArray.clone());

        System.out.println("\nQuick Sort:");
        sorter.quickSort(testArray.clone(), 0, testArray.length - 1);

        System.out.println("\nBucket Sort:");
        sorter.bucketSort(testArray.clone(), 10);
    }
}

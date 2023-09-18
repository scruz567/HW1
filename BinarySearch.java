public class BinarySearch {
    public static int binarySearch(int[] sortedArray, int low, int high, int element) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2; // adjust threshold

        if (element == sortedArray[mid]) { // element found
            return mid;
        } else if (element < sortedArray[mid]) { //element is in the lower half
            return binarySearch(sortedArray, low, mid - 1, element);
        } else { //element is in the upper half
            return binarySearch(sortedArray, mid + 1, high, element);
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[150000]; // change size of array
        int target = 7;
        long startTime = System.nanoTime(); // start runtime after array is created
        int index = binarySearch(sortedArray, 0, sortedArray.length - 1, target);
        long endTime = System.nanoTime(); // end of binarySearch
        long elapsedTime = endTime - startTime; // final runtime
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
        System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");
    }
}

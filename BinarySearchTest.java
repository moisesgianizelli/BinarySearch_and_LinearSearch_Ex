import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a binary search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether or not it contains an integer input from
 * the keyboard.
 *
 * @author Moises Munaldi
 * @date Dez/01/23
 * @version 1.0
 */
 class BinarySearchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //Task: create an array of 20 random integers between 1 to 100 
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = generator.nextInt(100) + 1;
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        //Task: which method should be used in Arrays class to make sure data in a sorted 
        //order
        Arrays.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        //Task: display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class, which method should we use to output data in a such 
        //format? (didnt get this question)
        //to-complete

        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("specific order " + Arrays.toString(array));


        //Task: repeatedly input an integer from user: -1 terminates the program
        //after reading an input of search key, we perform a binary search on 
        //data with this search key. Finaaly print out the result of the binary search as the
        //sample outputs provided in the task specification
        //to-complete

        int value;
        do {
            System.out.print("Enter an integer to search for (-1 to terminate): ");
            value = input.nextInt();

            if (value != -1) {
                int index = binarySearch(array, value);
                if (index >= 0) {
                    System.out.println("Array contains the value " + value + " at " + index);
                } else {
                    System.out.println("Array does not contain the value " + value);
                }
            }
        } while (value != -1);
        System.out.println("Program terminated.");
    }
/* =============================================================================
                           HELPER METHODS 
   =============================================================================
 */

    /**
     * To perform a binary search on an array of data without recursions
     *
     * @param data      a static array of integers
     * @param searchKey the search key of performing the search
     * @return -1 if the searchKey is not found in the data, otherwise the position
     * of the searchKey in the data
     */
    private static int binarySearch(int[] data, int searchKey) {
        int left = 0;
        int right = data.length - 1;

        do {
            int mid = left + (right - left) / 2;

            if (data[mid] == searchKey) {
                return mid;
            } else if (data[mid] < searchKey) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        } while (left <= right);

        return -1;
    }

    /**
     * To perform a binary search on an array of data with recursions
     *
     * @param data      a static array of integers
     * @param searchKey the search key of performing the search
     * @return -1 if the searchKey is not found in the data, otherwise the position
     * of the searchKey in the data
     */

    //its not complete as I am facing problems
//    private static int recursiveBinarySearch(int[] data, int searchKey) {
//        return recursiveBinarySearch(data, searchKey, 0, data.length - 1);
//    }
    private static int recBinSearch(int[] data, int searchKey, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (data[mid] == searchKey) {
            return mid;
        } else if (data[mid] < searchKey) {
            return recBinSearch(data, searchKey, mid + 1, right);
        } else {
            return recBinSearch(data, searchKey, left, mid - 1);
        }
    }
}
//    }
//    private static String formatArrayInSpecificOrder(int[] array) {
//        StringBuilder formattedArray = new StringBuilder("[");
//        for (int i = 0; i < array.length; i++) {
//            formattedArray.append(array[i]);
//            if (i < array.length - 1) {
//                formattedArray.append(", ");
//            }
//        }
//        formattedArray.append("]");
//        return formattedArray.toString();
//    }
//}

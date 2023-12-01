import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a linear search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether or not it contains an integer input from
 * the keyboard.
 *
 * @author Moises Munaldi
 * @date Dez/01/23
 * @version 1.0
 */
 class LinearSearchTest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //Task: create an array of 20 random integers between 1 to 100 
        //to-complete
         int[] array = new int[MAX_SIZE];
         for (int i = 0; i < MAX_SIZE; i++) {
             array[i] = generator.nextInt(100) + 1;
         }

        
        //Task: display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class, but which method will output in such a format?
        //to-complete      
         System.out.println("Array: " + formatArray(array));
//         private static String formatArray(int[] array) {
//             StringBuilder formattedArray = new StringBuilder("[");
//             for (int i = 0; i < array.length; i++) {
//                 formattedArray.append(array[i]);
//                 if (i < array.length - 1) {
//                     formattedArray.append(", ");
//                 }
//             }
//             formattedArray.append("]");
//             return formattedArray.toString();
//         }
        //Task: repeatedly input an integer from user: -1 terminates the program
        //after reading an input of search key, we perform a linear search on 
        //data with this search key. Finaaly print out the result of the linear
        //search
        //to-complete

         int value;
         do {
             System.out.print("Enter an integer to search for (-1 to terminate): ");
             value = input.nextInt();

             // Step 4: Perform a linear search on the array
             if (value != -1) {
                 int index = linearSearch(array, value);
                 if (index >= 0) {
                     System.out.println("Array " + value + " at  " + index);
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
 * To perform a linear search on an array of data
 *
 * @param data a static array of integers
 * @param searchKey the search key of performing the search
 * @return -1 if the searchKey is not found in the data, otherwise the position 
 * of the searchKey in the data
 */
private static int linearSearch(int[] data, int searchKey) {
    for (int i = 0; i < data.length; i++) {
        if (data[i] == searchKey) {
            return i;
        }
    }
    return -1;
}

/* ============================================================================
                            CLASS VARIABLES
   ============================================================================
 */
private static String formatArray(int[] array) {
    StringBuilder formattedArray = new StringBuilder("[");
    for (int i = 0; i < array.length; i++) {
        formattedArray.append(array[i]);
        if (i < array.length - 1) {
            formattedArray.append(", ");
        }
    }
    formattedArray.append("]");
    return formattedArray.toString();
}
    private static final int MAX_SIZE = 20;
}

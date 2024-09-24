// It give presentstion error
import java.util.Scanner;

public class BestBubble {

    // Function to count swaps for bubble sort
    private static int countSwaps(int[] arr, boolean ascending) {
        int n = arr.length;
        int swapCount = 0;
        
        // Bubble sort implementation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare based on ascending or descending order
                if ((arr[j] > arr[j + 1] && ascending) || (arr[j] < arr[j + 1] && !ascending)) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    // Function to get the minimum swaps required
    private static int minSwapsToBeautiful(int[] arr) {
        // Count swaps for ascending order
        int ascendingSwaps = countSwaps(arr.clone(), true);
        // Count swaps for descending order
        int descendingSwaps = countSwaps(arr.clone(), false);
        
        // Return the minimum of the two
        return Math.min(ascendingSwaps, descendingSwaps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of elements
        int N = scanner.nextInt();
        int[] arr = new int[N];
        
        // Input the array elements
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Get the result and print it
        int result = minSwapsToBeautiful(arr);
        System.out.println(result);
        
        scanner.close();
    }
}

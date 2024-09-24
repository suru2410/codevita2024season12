//it gives presentation error
import java.util.Scanner;

public class ZeroCount {

    // Function to calculate the longest contiguous block of zeros
    public static int longestBlockOfZeros(int L, int K) {
        // Calculate the number of zeros in the string
        int zeros = L - K;
        
        // If there are no zeros, the largest block is 0
        if (zeros == 0) {
            return 0;
        }
        
        // Divide the zeros into K + 1 parts (gaps between ones)
        int baseZeros = zeros / (K + 1); // Base size of each zero block
        int extraZeros = zeros % (K + 1); // Extra zeros that need to be distributed
        
        // The longest block of zeros will be baseZeros + 1 if extraZeros > 0
        if (extraZeros > 0) {
            return baseZeros + 1;
        } else {
            return baseZeros;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: length of the binary string and the number of ones
        int L = scanner.nextInt();
        int K = scanner.nextInt();

        // Calculate the longest contiguous block of zeros
        int result = longestBlockOfZeros(L, K);

        // Output the result
        System.out.println(result);

        scanner.close();
    }
}

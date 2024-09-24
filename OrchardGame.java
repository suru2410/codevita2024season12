import java.util.Scanner;

public class OrchardGame {

    // Method to count valid triplets for a given row of trees
    public static int countValidTriplets(String row) {
        int n = row.length();
        if (n < 3) return 0;  // Not enough trees for a triplet

        int count = 0;
        int leftM = 0; // Count of 'M' seen so far
        int leftL = 0; // Count of 'L' seen so far

        // Iterate over each tree starting from the second tree to the second last
        for (int j = 1; j < n - 1; j++) {
            // Update counts of M and L before position j
            if (row.charAt(j - 1) == 'M') {
                leftM++;
            } else {
                leftL++;
            }

            // Calculate valid triplets for the middle tree at position j
            if (row.charAt(j) == 'M') {
                // If the middle tree is 'M', we need 'L' on both sides
                count += leftL * (n - j - 1 - leftM);
            } else {
                // If the middle tree is 'L', we need 'M' on both sides
                count += leftM * (n - j - 1 - leftL);
            }
        }

        return count;
    }

    // Method to validate the input row
    public static boolean isValidRow(String row) {
        return row.matches("[ML]+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input rows for Ashok and Anand
        String ashokRow = scanner.nextLine();
        String anandRow = scanner.nextLine();

        // Validate input
        if (!isValidRow(ashokRow) || !isValidRow(anandRow)) {
            System.out.println("Invalid input");
            return;
        }

        // Count the number of valid triplets for Ashok and Anand
        int ashokCount = countValidTriplets(ashokRow);
        int anandCount = countValidTriplets(anandRow);

        // Determine the result based on the counts
        if (ashokCount > anandCount) {
            System.out.println("Ashok");
        } else if (anandCount > ashokCount) {
            System.out.println("Anand");
        } else {
            System.out.println("Draw");
        }

        scanner.close();
    }
}

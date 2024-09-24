// it give presentation error
import java.util.Scanner;

public class OrchardWinner {
    public static int countPossibilities(String row) {
        int n = row.length();
        int possibilities = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (row.charAt(i) != row.charAt(j)) {
                    for (int k = j + 1; k < n; k++) {
                        if (row.charAt(j) != row.charAt(k)) {
                            possibilities++;
                        }
                    }
                }
            }
        }
        return possibilities;
    }

    public static String orchardWinner(String ashokRow, String anandRow) {
        if (ashokRow == null || ashokRow.isEmpty() || anandRow == null || anandRow.isEmpty()) {
            return "Invalid input";
        }
        int ashokPossibilities = countPossibilities(ashokRow);
        int anandPossibilities = countPossibilities(anandRow);
        if (ashokPossibilities > anandPossibilities) {
            return "Ashok";
        } else if (ashokPossibilities < anandPossibilities) {
            return "Anand";
        } else {
            return "Draw";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ashokRow = scanner.nextLine();
        String anandRow = scanner.nextLine();
        System.out.println(orchardWinner(ashokRow, anandRow));
    }
}

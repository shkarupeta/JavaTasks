import java.util.Scanner;


/**
 * Use a recursion to display all the numbers from the 1st to the entered.
 */

public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(recursionCount(scanner.nextInt()));
        scanner.close();
    }

    /**
     * Using recursion
     * @param count entered number
     * @return sequence from 1 to count
     */
    private static String recursionCount(int count) {
        if (count == 1) {
            return "1";
        }
        return recursionCount(count - 1) + "\n" + count;
    }
}

import java.util.Scanner;


/**
 * At the beginning of each hour for three minutes the green light is on,
 * then for one minute - yellow,
 * and then for one minute - red,
 * then again the green light is on for three minutes, and so on.
 * Enter from the keyboard a number t, which means the time in minutes elapsed since the beginning of the next hour.
 * Determine what color signal is lit for pedestrians at that moment.
 * The result is displayed in the following form:
 * "green" - if the color is green,
 * "yellow" - if the color is yellow,
 * "red" - if the color is red.
 *
 * Example for number 2.5:
 * green
 * Example for number 3:
 * yellow
 * Example for number 4:
 * red
 * Example for number 5:
 * green
 * */

public class TrafficLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
            System.out.println(getColorByMinute(Double.parseDouble(line.replaceAll("\\W", "."))));
            scanner.close();
    }

    /**
     * @param minute
     * @return
     */
    private static String getColorByMinute(double minute) {
        double reminder = minute % 5;

        if (reminder >= 0 && reminder < 3) {
            return "green";
        }
        if (reminder >= 3 && reminder < 4) {
            return "yellow";
        }
        if (reminder >= 4 && reminder < 5) {
            return "red";
        }
        return "unknown";
    }
}

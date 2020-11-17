import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
            System.out.println(getColorByMinute(Double.parseDouble(line.replaceAll("\\W", "."))));
            scanner.close();
    }

    /**
     * @param minute from the beginning an hour
     * @return color traffic light from the beginning an hour
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

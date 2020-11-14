import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Change the address abbreviation to a full word in 2 ways
 * one of them RegExp.
 *
 * Ave -> Avenue
 * Ave. -> Avenue
 * St -> Street
 * St. -> Street
 * Str -> Street
 * Str. -> Street
 *
 * Input data:
 * 555 Straight Stave Ave, San Francisco, CA 94104
 * 444 Ave Maria Stairway St., San Francisco, CA 94104
 * 9032 Flave Steep Str, San Francisco, CA 94104
 *
 * Result:
 * 555 Straight Stave Avenue, San Francisco, CA 94104
 * 444 Ave Maria Stairway Street, San Francisco, CA 94104
 * 9032 Flave Steep Street, San Francisco, CA 94104
 * */

public class ChangeAbbrAddressToFull {
    private static String inputString;
    private static Map<String,String> dictionary;
    private static final File file = new File("InputTask2.txt");


    public static void main(String[] args) {
        dictionary = new HashMap<>();
        dictionary.put("Ave","Avenue");
        dictionary.put("Ave.","Avenue");
        dictionary.put("St","Street");
        dictionary.put("St.","Street");
        dictionary.put("Str","Street");
        dictionary.put("Str.","Street");

        setInputString();
        System.out.println("\nOutput with RegExp:");
        System.out.println(checkAbbrAndReplaceWithRegExp(getInputString()));
        System.out.println("\nOutput with dictionary:");
        System.out.println(checkAbbrAndReplaceWithDictionary(getInputString()));
    }

    /**
     *
     */
    private static void setInputString() {
        try {
            Scanner scanner = new Scanner(ChangeAbbrAddressToFull.file, StandardCharsets.UTF_8.name());
            inputString = scanner.useDelimiter("\\A").next();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param input
     * @return
     */
    private static String checkAbbrAndReplaceWithRegExp(String input){
        String strTmp = input;
        Pattern pattern = Pattern.compile("Ave(\\.)?,");
        Matcher matcher = pattern.matcher(strTmp);
        strTmp = matcher.replaceAll("Avenue,");

        pattern = Pattern.compile("St(r)?(\\.)?,");
        matcher = pattern.matcher(strTmp);
        strTmp = matcher.replaceAll("Street,");
        return strTmp;
    }

    /**
     * @param input
     * @return
     */
    private static String checkAbbrAndReplaceWithDictionary(String input){
        String strTmp = input;

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            strTmp = strTmp.replaceAll(entry.getKey() + ",",entry.getValue() + "," );
        }
        return strTmp;
    }

    /**
     * @return
     */
    public static String getInputString() {
        return inputString;
    }

}

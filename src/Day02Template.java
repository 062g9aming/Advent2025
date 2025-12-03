import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02Template {
    public static void main(String[] args) {

        // Day 2 day1 parsing set up
        // ------ DO NOT EDIT THE CODE HERE
        ArrayList<String> fileData = getFileData("src/day2");
        ArrayList<Long> productIDs = new ArrayList<Long>();
        for (String line : fileData)  {
            for (String s : line.split(",")) {
                long first = Long.parseLong(s.split("-")[0]);
                long second = Long.parseLong(s.split("-")[1]);
                for (long i = first; i <= second; i++) {
                    productIDs.add(i);
                }
            }
        }
        // Day 2 day1 parsing set up complete
        // "productIDs" is a list of "long" variables that make up each product ID from the file

        long partOneAnswer = 0;

        for (Long p : productIDs) {
            if (isInvalidProductID(p)) {
                partOneAnswer += p;
            }

        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD. This method should return "true"
    // if the product ID is INVALID. "false" otherwise.
    public static boolean isInvalidProductID(long productID) {
        String pID = productID + "";
        int length = pID.length();
        if (pID.length() % 2 == 1)
        {
            return false;
        }
        String segment1 = pID.substring(0, (length-1)/2 + 1);
        String segment2 = pID.substring((length-1)/2 + 1);
        if (segment1.equals(segment2))
        {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
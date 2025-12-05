import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03Template {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/day3");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        int highestVolt = 0;
        System.out.println(batteries);
        for (int i = 0; i < batteries.length(); i++)
        {
            int tens = Integer.parseInt(batteries.substring(i,i+1));
            for (int v = 0; v < batteries.length(); v++)
            {
                if (v > i)
                {
                    int ones = Integer.parseInt(batteries.substring(v,v+1));
                    //int newVolt = 10*(Integer.parseInt(String.valueOf(batteries.charAt(i))) + (Integer.parseInt(String.valueOf(batteries.charAt(v)))));
                    int newVolt = 10*tens + ones;
                    if (highestVolt < newVolt)
                    {
                        highestVolt = newVolt;;
                    }
                }
            }
        }
        System.out.println(highestVolt);
        return highestVolt;
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
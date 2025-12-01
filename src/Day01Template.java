import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01Template {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");

        int position = 50;
        int partOneAnswer = 0;
        for (String line : fileData) {

            String direction = line.substring(0,1);
            int amount = Integer.parseInt(line.substring(1));
            System.out.println("Rotate " + direction + " " + amount + " times");
            position = doRotation(direction, amount, position);


        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    public static int doRotation(String direction, int amount, int startPosition) {
        int newPosition = -1;

        return newPosition;
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
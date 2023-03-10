import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOOperation {
    public static int enterFromConsole(String message) {
        int number;
        do {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println(message);
            }
            number = sc.nextInt();
        }
        while (number <= 0);
        return number;
    }

    public static ArrayList<Character> readFromFile(String fileName) {
        ArrayList<Character> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int i;
            while ((i = bufferedReader.read()) != -1) {
                list.add((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void writeToFile(String fileName, ArrayList<Character> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Character character : list) {
                bufferedWriter.append(character);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

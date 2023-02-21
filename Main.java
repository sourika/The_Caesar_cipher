import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String src = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForEncipher.txt";
        String dest = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForDecipher.txt";
        String text = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForBreakCipher.txt";
        String choice = "What method do you want to try? Press 1 for Caesar cipher/decipher or press 2 for Brute force";
        String choiceCaesar = "What Caesar method do you want to try? Press 1 for cipher or press 2 for decipher";
        String shift = "Enter any positive integer (the cipher key)";
        ArrayList<Character> chars;
        ArrayList<Character> result;

        while (true) {
            int number = IOOperation.enterFromConsole(choice);
            if (number == 1) {
                while (true) {
                    int numberCaesar = IOOperation.enterFromConsole(choiceCaesar);
                    if (numberCaesar == 1) {
                        int cipherKey = IOOperation.enterFromConsole(shift);
                        chars = IOOperation.readFromFile(src);
                        result = Cipher.encipher(chars, cipherKey);
                        IOOperation.writeToFile(dest, result);
                        break;
                    } else if (numberCaesar == 2) {
                        int cipherKey = IOOperation.enterFromConsole(shift);
                        chars = IOOperation.readFromFile(dest);
                        result = Cipher.decipher(chars, cipherKey);
                        IOOperation.writeToFile(src, result);
                        break;
                    }
                }
                break;
            } else if (number == 2) {
                chars = IOOperation.readFromFile(text);
                result = BreakCipher.breakCipher(chars);
                IOOperation.writeToFile(src, result);
                break;
            }
        }
    }
}




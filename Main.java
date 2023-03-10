import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String src = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForEncipher.txt";
        String dest = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForDecipher.txt";
        String text = "D:\\JAVA\\IdeaProjects\\module01\\src\\TextForCryptAnalysis.txt";
        String choiceMode = "What method do you want to try? Press 1 for Caesar cipher/decipher or press 2 for cryptanalysis ";
        String choiceCaesar = "Choose Caesar method. Press 1 for cipher or press 2 for decipher ";
        String choiceAnalysis = "Choose cryptanalysis method. Press 1 for brute force or press 2 for statistical analysis ";
        String shift = "Enter any positive integer (the cipher key) ";
        ArrayList<Character> chars;
        ArrayList<Character> result;

        while (true) {
            int number = IOOperation.enterFromConsole(choiceMode);
            if (number == 1) {
                while (true) {
                    int numberCaesar = IOOperation.enterFromConsole(choiceCaesar);
                    int cipherKey = IOOperation.enterFromConsole(shift);
                    if (numberCaesar == 1) {
                        chars = IOOperation.readFromFile(src);
                        result = Cipher.encipher(chars, cipherKey);
                        IOOperation.writeToFile(dest, result);
                        break;
                    } else if (numberCaesar == 2) {
                        chars = IOOperation.readFromFile(dest);
                        result = Cipher.decipher(chars, cipherKey);
                        IOOperation.writeToFile(src, result);
                        break;
                    }
                }
                break;
            } else if (number == 2) {
                while (true) {
                    int numberAnalysis = IOOperation.enterFromConsole(choiceAnalysis);
                    chars = IOOperation.readFromFile(text);
                    if (numberAnalysis == 1) {
                        result = BreakCipher.breakCipher(chars);
                        break;
                    } else if (numberAnalysis == 2) {
                        result = StatAnalysis.statAnalysis(chars);
                        break;
                    }
                }
                IOOperation.writeToFile(src, result);
                break;
            }
        }
    }
}





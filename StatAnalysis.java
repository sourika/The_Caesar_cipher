import java.util.ArrayList;
import java.util.HashMap;

public class StatAnalysis {
    static String additText = "D:\\JAVA\\IdeaProjects\\module01\\src\\AdditTextForStatAnalysis.txt";

    public static ArrayList<Character> statAnalysis(ArrayList<Character> charsForStatAnalysis) {
        HashMap<Integer, ArrayList<Integer>> result = BreakCipher.countLetters(charsForStatAnalysis);
        ArrayList<Character> list = IOOperation.readFromFile(additText);
        ArrayList<Double> expectedFrequency = new ArrayList<>();
        for (int j = 0; j < 33; j++) {
            int countLetter = 0;
            for (Character character : list) {
                if (Cipher.ALPHABET.get(j) == Character.toLowerCase(character)) {
                    countLetter++;
                }
            }
            expectedFrequency.add((double) countLetter / list.size() * charsForStatAnalysis.size());
        }
        int likelyKey = BreakCipher.findLikelyKey(expectedFrequency, result);
        return Cipher.decipher(charsForStatAnalysis, likelyKey);
    }
}
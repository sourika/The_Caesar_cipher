import java.util.ArrayList;
import java.util.HashMap;

public class BreakCipher {

    public static final double[] RUSSIAN_LETTERS_FREQUENCIES = {0.07998, 0.01592, 0.04533, 0.01687, 0.02977, 0.08483, 0.00013,
            0.0094, 0.01641, 0.07367, 0.01208, 0.03486, 0.04343, 0.03203, 0.0067, 0.10983, 0.02804, 0.04746, 0.05473,
            0.06318, 0.02615, 0.00267, 0.00966, 0.00486, 0.0145, 0.00718, 0.00361, 0.00037, 0.01898, 0.01735, 0.00331,
            0.00639, 0.02001};


    public static ArrayList<Character> breakCipher(ArrayList<Character> charsForBreakCipher) {
        HashMap<Integer, ArrayList<Integer>> result = countLetters(charsForBreakCipher);
        ArrayList<Double> expectedFrequency = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            expectedFrequency.add(RUSSIAN_LETTERS_FREQUENCIES[i] * charsForBreakCipher.size());
        }
        int likelyKey = findLikelyKey(expectedFrequency, result);
        return Cipher.decipher(charsForBreakCipher, likelyKey);
    }

    public static int findLikelyKey(ArrayList<Double> expectedFrequency, HashMap<Integer, ArrayList<Integer>> result) {
        ArrayList<Double> xiSquares = new ArrayList<>();
        for (int shift = 0; shift < 74; shift++) {
            double sum = 0;
            for (int i = 0; i < 33; i++) {
                if (expectedFrequency.get(i) != 0) {
                    double xiSquare = Math.pow((expectedFrequency.get(i) - result.get(shift).get(i)), 2) / expectedFrequency.get(i);
                    sum += xiSquare;
                }
            }
            xiSquares.add(sum);
        }
        double minCount;
        minCount = xiSquares.get(0);
        for (int shift = 0; shift < 74; shift++) {
            if (xiSquares.get(shift) < minCount) {
                minCount = xiSquares.get(shift);
            }
        }
        return xiSquares.indexOf(minCount);
    }

    public static HashMap<Integer, ArrayList<Integer>> countLetters(ArrayList<Character> text) {
        HashMap<Integer, ArrayList<Integer>> mapOfLetters = new HashMap<>();
        for (int shift = 0; shift < 74; shift++) {
            ArrayList<Character> decipherText = Cipher.decipher(text, shift);
            ArrayList<Integer> frequencies = new ArrayList<>();
            for (int j = 0; j < 33; j++) {
                int countLetter = 0;
                for (Character character : decipherText) {
                    if (Cipher.ALPHABET.get(j) == Character.toLowerCase(character)) {
                        countLetter++;
                    }
                }
                frequencies.add(countLetter);
            }
            mapOfLetters.put(shift, frequencies);
        }
        return mapOfLetters;
    }
}
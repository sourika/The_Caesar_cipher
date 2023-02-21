import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {

    public static final ArrayList<Character> ALPHABET = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '.', ',', '"', ':', '-', '!', '?', ' '));

    public static ArrayList<Character> encipher(ArrayList<Character> charsForEncipher, int key) {
        ArrayList<Character> resultOfEncipher = new ArrayList<>();
        for (int i = 0; i < charsForEncipher.size(); ++i) {
            char ch = charsForEncipher.get(i);
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                resultOfEncipher.add(i, ALPHABET.get((index + key) % 74));
            } else {
                resultOfEncipher.add(i, ch);
            }
        }
        return resultOfEncipher;
    }

    public static ArrayList<Character> decipher(ArrayList<Character> charsForDecipher, int key) {
        ArrayList<Character> resultOfDecipher = new ArrayList<>();
        for (int i = 0; i < charsForDecipher.size(); ++i) {
            char ch = charsForDecipher.get(i);
            int index = ALPHABET.indexOf(ch);
            int diff = index - key % 74;
            if (index != -1) {
                if (diff >= 0) {
                    resultOfDecipher.add(i, ALPHABET.get(diff));
                } else {
                    resultOfDecipher.add(i, ALPHABET.get(74 - Math.abs(diff)));
                }
            } else {
                resultOfDecipher.add(i, ch);
            }
        }
        return resultOfDecipher;
    }
}


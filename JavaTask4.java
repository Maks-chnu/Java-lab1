package Java_lab1;
import java.util.Scanner;

public class JavaTask4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String text = in.nextLine();

        StringBuilder result = new StringBuilder();   
        StringBuilder word = new StringBuilder();     
        StringBuilder removed = new StringBuilder(); 
        int removedCount = 0;

        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isWordChar(c)) {
                word.append(c);                       
            } else {
                removedCount += flushWord(word, result, removed);
                result.append(c);                      
            }
        }
        removedCount += flushWord(word, result, removed); 

        // Прибираємо зайві пробіли, що лишились після вилучення слів
        String cleaned = result.toString()
                .replaceAll("\\s+", " ")               
                .replaceAll(" ([,.:;!?])", "$1")       
                .trim();

        // Виведення результату
        System.out.println("\nПочатковий текст: " + text);
        if (removedCount == 0) {
            System.out.println("Слів непарної довжини немає, текст не змінено.");
        } else {
            System.out.println("Вилучено слів: " + removedCount + " (" + removed + ")");
            if (cleaned.isEmpty()) {
                System.out.println("Усі слова мали непарну довжину, текст порожній.");
            } else {
                System.out.println("Результат: " + cleaned);
            }
        }

        in.close();
    }

    // Чи є символ частиною слова (літера, цифра або апостроф)
    private static boolean isWordChar(char c) {
        return Character.isLetterOrDigit(c) || c == '\'' || c == '’';
    }

    // Обробляє зібране слово: парне — додає в результат, непарне — вилучає.
    // Повертає 1, якщо слово вилучено, інакше 0.
    private static int flushWord(StringBuilder word, StringBuilder result, StringBuilder removed) {
        if (word.length() == 0) {
            return 0;
        }
        int removedNow = 0;
        if (word.length() % 2 == 0) {
            result.append(word);
        } else {
            if (removed.length() > 0) {
                removed.append(", ");
            }
            removed.append(word);
            removedNow = 1;
        }
        word.setLength(0);
        return removedNow;
    }
}


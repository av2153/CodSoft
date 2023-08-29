import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Word Counter");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.println("Enter a text: ");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }

        Map<String, Integer> wordCountMap = countWords(text);

        System.out.println("Word Count:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Total words: " + wordCountMap.size());
        scanner.close();
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Remove punctuation and split the text into words
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        // Count the occurrences of each word
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            sb.append(System.lineSeparator());
        }

        scanner.close();
        return sb.toString();
    }
}

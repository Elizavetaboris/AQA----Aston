import java.util.*;
public class Main {
   public static void main(String[] args) {
      ArrayList<String> wordList = new ArrayList<>(Arrays.asList("Дом", "Мяч", "Собака", "Кошка", "Папа", "Дочь", "Мама", "Папа", "Дом", "Мяч", "Помада", "Очки", "Звезды", "Собака", "Кошка", "Мяч", "Луна", "Звезды", "Море", "Дочь"));
      Set<String> uniqueWords = new HashSet<>(wordList);
      Map<String, Integer> wordCount = new HashMap<>();
      for (String word : wordList) {
         wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }
      System.out.println("Список уникальных слов: " + uniqueWords);
      System.out.println("Количество повторений каждого слова: " + wordCount);

      Phonebook phonebook = new Phonebook();
      phonebook.add("Иванов", "12345");
      phonebook.add("Петров", "67890");
      phonebook.add("Иванов", "54321");
      phonebook.add("Кошкин", "54321");
      phonebook.add("Кошкин", "54411");

      System.out.println("Номера Иванова: " + phonebook.get("Иванов"));
      System.out.println("Номера Кошкина: " + phonebook.get("Кошкин"));
   }
}


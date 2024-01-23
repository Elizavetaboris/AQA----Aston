import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Генерация случайных чисел
        Random random = new Random();
        int[] numbers = new int[20];
        int countEven = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
            if (numbers[i] % 2 == 0) {
                countEven++;
            }
        }
        System.out.println("Количество четных чисел: " + countEven);

        // Манипуляции с коллекцией строк
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("Highload");
        collection1.add("High");
        collection1.add("Load");
        collection1.add("Highload");

        int countHigh = Collections.frequency(collection1, "High");
        System.out.println("Количество вхождений 'High': " + countHigh);

        String firstElement = collection1.isEmpty() ? "0" : collection1.get(0);
        System.out.println("Первый элемент коллекции: " + firstElement);

        String lastElement = collection1.isEmpty() ? "0" : collection1.get(collection1.size() - 1);
        System.out.println("Последний элемент коллекции: " + lastElement);

        // Сортировка и добавление элементов в массив
        ArrayList<String> collection2 = new ArrayList<>();
        collection2.add("f10");
        collection2.add("f15");
        collection2.add("f2");
        collection2.add("f4");
        collection2.add("f4");
        Collections.sort(collection2);
        System.out.println("Отсортированный массив: " + collection2);
    }
}

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    // Метод для печати трех слов
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Метод для проверки знака суммы
    public static void checkSumSign() {
        int a = 12;
        int b = 17;
        int sum = a + b;
        System.out.println("Сумма " + (sum >= 0 ? "положительная" : "отрицательная"));
    }

    // Метод для определения цвета
    public static void printColor() {
        int value = 75;
        String color = (value < 0) ? "Красный" : ((value < 100) ? "Желтый" : "Зеленый");
        System.out.println(color);
    }

    // Метод для сравнения чисел
    public static void compareNumbers() {
        int a = 13;
        int b = 18;
        System.out.println(a + (a >= b ? " >= " : " < ") + b);
    }
}
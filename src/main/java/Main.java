public class Main {
    public static void main(String[] args) {
        // Создаем коробки для яблок и апельсинов
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // Выводим вес коробок
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        // Сравниваем коробки
        System.out.println("Коробки равны по весу: " + appleBox1.compare(orangeBox));

        // Пересыпаем фрукты
        Box<Apple> appleBox2 = new Box<>();
        appleBox1.transfer(appleBox2);

        // Выводим содержимое коробки после пересыпания
        System.out.println("Содержимое коробки с яблоками:");
        appleBox1.printContents();
        System.out.println("Содержимое новой коробки с яблоками:");
        appleBox2.printContents();
    }
}



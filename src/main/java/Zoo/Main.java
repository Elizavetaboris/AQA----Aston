package Zoo;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Лео");
        Dog dog2= new Dog("Барбос");
        dog1.anRun(100);
        dog2.anSwim(30);
        dog1.anRun(400);
        dog2.anSwim(5);

        Cat cat1 = new Cat("Мурзик",10);
        Cat cat2= new Cat("Пушистик",5);
        cat1.anRun(100);
        cat1.anSwim(300);
        cat2.anRun(200);
        cat2.anSwim(100);

        System.out.println("Кол-во созданных животных: "+ Animal.animalsCount);

        Cat[] cats = {new Cat("Кузя",6),new Cat("Барсик",4),new Cat("Рон",3)};
        Bowl bowl = new Bowl(10);
        for (Cat cat : cats){
            cat.eat(bowl);
        }
        System.out.println("Сытость котов: ");
        for (Cat cat : cats){
            System.out.println(cat.isSatiety());
        }
        bowl.addFood(10);
    }
}

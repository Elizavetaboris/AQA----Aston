package Zoo;

class Cat extends Animal {
    private final int appetite;
    private boolean satiety;
    private static  int catCount;

    public Cat(String name, int appetite) {
        super(name, 200,0);
        catCount++;
        this.appetite = appetite;
        this.satiety = false;
    }
    public static int getCatCount() {
        return catCount;
    }
    @Override
    public void anSwim(int length) {
        System.out.println("плавание: кот не умеет плавать,");
    }
    public void eat(Bowl bowl){
        if (bowl.decreaseFood(appetite)) {
            satiety = true;
            System.out.println(name + " поел и наелся!");
        } else {
            System.out.println(name + " не поел, так как в миске недостаточно еды!");
        }
    }
    public  boolean isSatiety() {
        return satiety;
    }
}


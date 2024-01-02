class Cat extends Animal{
    private int appetite;
    private boolean satiety;


    public Cat(String name,int appetite){
        super(name,200,0);
        this.appetite = appetite;
        this.satiety = false;

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


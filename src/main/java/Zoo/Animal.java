package Zoo;

public class Animal {
    String name;
    static int animalsCount;
    int runLimit;
    int swimLimit;

    public Animal(String name,int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalsCount++;
    }

    public void anRun(int lenght) {
        if (lenght <= runLimit) {
            System.out.println(name + " пробежал: " + lenght + " метров");
        } else {
            System.out.println(name + " не может пробежать: " + lenght + " метров");
        }
    }

    public void anSwim(int lenghth) {
        if (lenghth <= swimLimit) {
            System.out.println(name +" проплыл: " + lenghth+ " метров");
        } else {
            System.out.println(name +" не может проплыть: " + lenghth+ " метров");
        }
    }
}

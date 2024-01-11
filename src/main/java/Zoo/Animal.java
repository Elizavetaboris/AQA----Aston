package Zoo;

public class Animal {
    String name;
    public static int animalCount;
    int runLimit;
    int swimLimit;
    public Animal(String name,int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }
    public void anRun(int lenght) {
        if (lenght <= runLimit) {
            System.out.println(name + " пробежал: " + lenght + " метров");
        } else {
            System.out.println(name + " не может пробежать: " + lenght + " метров");
        }
    }
    public void anSwim(int lenght) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать");
        }else if(lenght <= swimLimit){
            System.out.println(name + " проплыл: " + lenght + " метров");
        } else {
            System.out.println(name + " не может проплыть: " + lenght + " метров");
        }
    }
    public static int  getAnimalCount(){
            return animalCount;
        }
}

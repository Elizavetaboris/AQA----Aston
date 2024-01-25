import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                weight += 1.0f;
            } else if (fruit instanceof Orange) {
                weight += 1.5f;
            }
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transfer(Box<? super T> anotherBox) {
        if (this.getClass() == anotherBox.getClass()) {
            anotherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        } else {
            System.out.println("Нельзя пересыпать яблоки в коробку с апельсинами!");
        }
    }
    public void printContents() {
        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                System.out.println("Яблоко");
            } else if (fruit instanceof Orange) {
                System.out.println("Апельсин");
            }
        }
    }
}
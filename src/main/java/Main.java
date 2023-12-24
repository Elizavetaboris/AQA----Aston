public class Main {
    public static void main(String[] args) {
        withIn(2, 10);
        numberCheck(-10);
        numCheck(12);
        numStr("Liza",5);

    }

    public static void withIn(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    public static void numberCheck(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static void numCheck(int a) {
        if (a >= 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
    public static void numStr(String a,int b){
        for(int i=0;i<b;i++){
            System.out.println(a);
        }
    }
}

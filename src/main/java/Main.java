public class Main {
    public static void main(String[] args) {
        WithIn(2,10);

    }
    public static void WithIn(int a,int b){
        int sum = a + b;
        if(sum >= 10 && sum <= 20){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

    }
}

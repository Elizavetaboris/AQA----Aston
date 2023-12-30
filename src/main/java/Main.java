import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        withIn(2, 10);
        numberCheck(-10);
        numCheck(12);
        numStr("Liza", 2);
        leyeCheck(2024);
        int[] ar = {1, 0, 1, 0, 1, 1,0,1,0,1,0,1,0,};
        int[] arr = new int[100];
        int[] lar = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        zerArr(ar);
        hundArr(arr);
        lessArr(lar);
        int size = 4;
        int[][] twoDim = new int[size][size];
        twoDimArr(twoDim, size);
        int len = 5;
        int initialValue = 2;
        int[] result = crArr(len, initialValue);
        System.out.println("result: " + Arrays.toString(result));
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
    public static void numStr(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }
    public static void leyeCheck(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
    public static void zerArr(int[] ar) {
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == 1) {
                    ar[i] = 0;
                } else  {
                    ar[i] = 1;
                }
            }
        System.out.println(Arrays.toString(ar));
    }
    public static void hundArr(int[] arr) {
        {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            for (int number : arr) {
                System.out.println(number + " ");
            }
        }
    }
    public static void lessArr(int[] lar) {
        {
            for (int i = 0; i < lar.length; i++) {
               if( lar[i] < 6 ) {
                   lar[i] = lar[i] * 2;
               }
            }
            for (int number : lar) {
                System.out.println(number + " ");
            }
        }
    }
    public static void twoDimArr(int[][] twoDim,int size){
        for (int i = 0; i < size; i++) {
            twoDim[i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(twoDim[i][j] + " " );
            }
            System.out.println();
        }
    }
    public static int[] crArr(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr,initialValue);
        return arr;
    }
}









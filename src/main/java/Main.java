import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.header = new String[]{"Value1", "Value2", "Value3"};
        appData.data = new int[][]{{100,200,300}, {300,400,500}};

        appData.save("data.csv");

        AppData loadedData = new AppData();
        loadedData.load("data.csv");

        System.out.println("Header: " + Arrays.toString(loadedData.header));
        for (int[] row : loadedData.data) {
            System.out.println(Arrays.toString(row));
        }
    }
}


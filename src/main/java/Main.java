import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.header = new String[]{"Value1", "Value2", "Value3"};
        appData.data = new int[][]{{100,200,300}, {300,400,500}};


        appData.save("data.csv"); // Сохранение данных в CSV-файл

        AppData loadedData = new AppData();
        loadedData.load("data.csv"); // Загрузка данных из CSV-файла

        // Пример вывода загруженных данных
        System.out.println("Header: " + Arrays.toString(loadedData.header));
        for (int[] row : loadedData.data) {
            System.out.println(Arrays.toString(row));
        }


    }
}


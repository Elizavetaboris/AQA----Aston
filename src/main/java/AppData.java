import java.io.*;
import java.util.Arrays;

public class AppData {
    public String[] header;
    public int[][] data;
    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(String.join(";", header));
            for (int[] row : data) {
                writer.println(String.join(";", Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            header = reader.readLine().split(";");
            String line;
            int dataSize = (int) reader.lines().count();
            data = new int[dataSize][header.length];
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader newReader = new BufferedReader(new FileReader(filePath))) {
            newReader.readLine(); // Skip header line
            int index = 0;
            String line;
            while ((line = newReader.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    data[index][i] = Integer.parseInt(values[i]);
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


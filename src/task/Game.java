package task;

import java.io.*;
import java.io.File;
import java.util.Arrays;

public class Game {

    public void writeGameToFile(String fileName) throws IOException{
        byte[] gameElement = {0, 1, 2, 3, 0, 1, 2, 3, 0};
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < 3; i++) {
                byte row = 0;
                for (int j = 0; j < 3; j++)
                    row += gameElement[i * 3 + j] << (j * 2);
                outputStream.write(row);
            }
            outputStream.flush();
        } catch (IOException e) {
            throw new IOException(e.getCause());
        }
        System.out.println("The original array of 9 elements has the range [0, 3]");
        System.out.println(Arrays.toString(gameElement));
        System.out.println("\nArray saved to file '" + fileName + "'");
    }


    public void printSizeOfFile(String fileName) {
        File file = new File(fileName);
        if ((file.exists()) && (file.isFile())) {
            System.out.println("File size '" + fileName + "': "  + file.length() + " bytes");
        }
    }

}

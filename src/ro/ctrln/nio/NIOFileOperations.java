package ro.ctrln.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NIOFileOperations {

    public static void main(String[] args) throws IOException {


        try(FileInputStream fileInputStream = new FileInputStream("data.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt")) {

            FileChannel fileChannel = fileInputStream.getChannel();

            int byteRead = fileInputStream.read();
            while (byteRead != -1) {
                fileOutputStream.write(byteRead);
                byteRead = fileInputStream.read();
            }
        }

        byte[] allBytes = Files.readAllBytes(Paths.get("data.txt"));
        System.out.println(new String(allBytes));

        List<String> allLines = Files.readAllLines(Paths.get("data.txt"));
        allLines.forEach(line-> System.out.println(line.concat(" some additional")));
    }
}

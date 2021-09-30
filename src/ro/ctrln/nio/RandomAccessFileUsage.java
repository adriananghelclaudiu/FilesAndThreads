package ro.ctrln.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileUsage {

    public static void main(String[] args) {

        try(RandomAccessFile randomAccessFile = new RandomAccessFile("data.txt", "rw")) {

            randomAccessFile.seek(1);

            byte[] partOfFile = new byte[10];
            randomAccessFile.read(partOfFile);

            System.out.println("Bucatica din fisier: " + new String(partOfFile));

            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write("\nText adaugat cu operatiile din java.io.RandomAccessFile".getBytes(StandardCharsets.UTF_8));

            randomAccessFile.seek(43);
            randomAccessFile.write(" importante".getBytes(StandardCharsets.UTF_8));

            System.out.println("Locatia curenta a pointerului este: " + randomAccessFile.getFilePointer());

            char readOne = (char) randomAccessFile.read();
            System.out.println("readOne: " + readOne);
            char readTwo = (char) randomAccessFile.read();
            System.out.println("readTwo: " + readTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

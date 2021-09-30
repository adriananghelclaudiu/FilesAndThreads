package ro.ctrln.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelUsage {

    public static void main(String[] args) {
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("data.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(2056);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();

            int i = 0;
            while(i < fileChannel.size()) {
                System.out.print((char)byteBuffer.get());
                i++;
            }

        } catch(IOException ioException) {
            // write in the log
        }
    }
}

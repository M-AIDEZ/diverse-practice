package maidez.practices.nio;

import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class NIOReader {
    public static String readFile(String filePath) throws IOException {
        RandomAccessFile aFile = null;
        try {
            StringBuilder sb = new StringBuilder();
            aFile = new RandomAccessFile(filePath, "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    sb.append((char) buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
            return sb.toString();
        } finally {
            if (aFile != null) {
                aFile.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            NIOReader.readFile("src/main/resources/William_Shakespeare.txt");
            stopwatch.stop();
            System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package maidez.practices.nio;

import com.google.common.base.Stopwatch;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class IOReader {
    public static String readFile(String filePath) throws IOException {
        BufferedReader in = null;
        try {
            StringBuilder sb = new StringBuilder();
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            char[] buf = new char[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++)
                    sb.append(buf[i]);
                bytesRead = in.read(buf);
            }
            return sb.toString();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            IOReader.readFile("src/main/resources/William_Shakespeare.txt");
            stopwatch.stop();
            System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

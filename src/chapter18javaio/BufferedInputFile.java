package chapter18javaio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/15
 * Mail:zhengjun1987@outlook.com
 */
public class BufferedInputFile {
    public static String read(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = bufferedReader.readLine()) != null) {
            stringBuffer.append(s+"\n");
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("src/chapter18javaio/Test.java"));
    }
}

package chapter18javaio;

import java.io.IOException;
import java.io.StringReader;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/15
 * Mail:zhengjun1987@outlook.com
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFile.read(Config.FILE_PATH + "PPrint.java"));
        
    }
}
